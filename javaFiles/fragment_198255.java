import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class TableParser {
    private Map<Integer, Map<Integer, String>> cells = new LinkedHashMap<>();

    private void parseTable(Element table) {
        int rowNum = 0;
        for (Element row : table.select("> tbody > tr")) {
            parseRow(rowNum++, row);
        }
    }

    private void parseRow(int rowNum, Element row) {
        int columnNum = 0;
        for (Element cell : row.select("> td")) {
            String colspanText = cell.attr("colspan");
            int colspan = 1;
            if (StringUtils.isNotBlank(colspanText))
                colspan = Integer.parseInt(colspanText);

            addCell(rowNum, columnNum, colspan, cell);
            parseCell(rowNum, columnNum, cell);

            columnNum += colspan;
        }
    }

    private void addCell(int rowNum, int columnNum, int colspan, Element cell) {
        Map<Integer, String> rowCells = cells.computeIfAbsent(rowNum,
                r -> new LinkedHashMap<>());
        for (int i = 0; i < colspan; i++)
            rowCells.put(columnNum + i, labelIn(cell));
    }

    private String labelIn(Element cell) {
        return cell.textNodes().get(0).text().trim();
    }

    private String cellAt(int rowNum, int columnNum) {
        Map<Integer, String> rowCells = cells.get(rowNum);
        if (rowCells == null)
            return null;
        return rowCells.get(columnNum);
    }

    private void parseCell(int rowNum, int columnNum, Element cell) {
        // Don't drill down into the nested table yet
        if (!cell.select("table").isEmpty())
            return;
        for (Element input : cell.select("input")) {
            String label = labelIn(cell);
            if (StringUtils.isBlank(label))
                label = cellAt(rowNum, columnNum - 1);
            if (StringUtils.isBlank(label))
                label = cellAt(rowNum - 1, columnNum);
            System.out.println(String.format("%s->%s at (%d,%d)", label,
                    input.attr("name"), rowNum, columnNum));
        }
    }

    public static void main(String[] args) throws IOException {
        Document doc = Jsoup.parse(new java.io.File("/temp/labels.html"),
                java.nio.charset.StandardCharsets.UTF_8.name());
        for (Element table : doc.select("table")) {
            new TableParser().parseTable(table);
        }
    }
}