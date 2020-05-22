import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellUtil;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PoiColors {

    public static void main(String[] args) throws IOException {

        List<PriceListItem> priceList = new ArrayList<>();

        PriceListItem noChange = new PriceListItem();
        noChange.modelNumber = "123";
        noChange.price = BigDecimal.valueOf(1.99);
        noChange.changeType = ChangeType.NO_CHANGE;

        PriceListItem addition = new PriceListItem();
        addition.modelNumber = "456";
        addition.price = BigDecimal.valueOf(2.99);
        addition.changeType = ChangeType.ADDITION;

        PriceListItem deletion = new PriceListItem();
        deletion.modelNumber = "789";
        deletion.price = BigDecimal.valueOf(3.99);
        deletion.changeType = ChangeType.DELETION;

        PriceListItem increase = new PriceListItem();
        increase.modelNumber = "234";
        increase.price = BigDecimal.valueOf(4.99);
        increase.changeType = ChangeType.PRICE_ADJUSTMENT_INCREASE;

        PriceListItem decrease = new PriceListItem();
        decrease.modelNumber = "345";
        decrease.price = BigDecimal.valueOf(5.99);
        decrease.changeType = ChangeType.PRICE_ADJUSTMENT_DECREASE;

        priceList.add(noChange);
        priceList.add(addition);
        priceList.add(deletion);
        priceList.add(increase);
        priceList.add(decrease);

        new PoiColors().exportPriceList(priceList, "acme.xlsx");

    }

    private void exportPriceList(
            List<PriceListItem> priceList,
            String targetAbsPath) throws IOException {

        // set variables based on specified format
        String templateName = "price-list-template.xlsx";

        // load the template
        InputStream inp = this.getClass().getClassLoader().getResource(templateName).openStream();
        Workbook workbook = WorkbookFactory.create(inp);

        Sheet sheet = workbook.getSheetAt(0);
        workbook.setSheetName(workbook.getSheetIndex(sheet), "ACME");

        // plug in the header/metadata info and format some headers so they get autosized properly
        Row row2 = CellUtil.getRow(1, sheet);
        Cell c2 = CellUtil.getCell(row2, 2);
        c2.setCellValue("ACME");


        // create the data rows and apply styling
        // start at row #11 which is where data rows begin
        int rowNum = 11;

        // rip through the items and write them to the rows; apply styling as appropriate
        for (PriceListItem priceListItem : priceList) {

            Row nextRow = sheet.createRow(rowNum);

            Cell changeType = nextRow.createCell(0);
            changeType.setCellValue(priceListItem.changeType.name());
            applyPriceListDataCellStyle(priceListItem, changeType);

            Cell modelNumber = nextRow.createCell(1);
            modelNumber.setCellValue(priceListItem.modelNumber);
            applyPriceListDataCellStyle(priceListItem, modelNumber);

            Cell price = nextRow.createCell(2);
            price.setCellValue(priceListItem.price.doubleValue());
            applyPriceListDataCellStyle(priceListItem, price);

            rowNum++;

        }

        // resize the columns appropriately
        for (int c = 0; c < 3; c++) {
            sheet.autoSizeColumn(c);
        }


        // export to file system
        FileOutputStream fos = new FileOutputStream(targetAbsPath);
        workbook.write(fos);

        fos.close();
        inp.close();
        workbook.close();

    }

    private void applyPriceListDataCellStyle(PriceListItem priceListItem, Cell cell) {

        short colorIndex;
        switch(priceListItem.changeType) {
            case ADDITION:
                colorIndex = IndexedColors.YELLOW.getIndex();
                break;
            case DELETION:
                colorIndex = IndexedColors.VIOLET.getIndex();
                break;
            case PRICE_ADJUSTMENT_INCREASE:
                colorIndex = IndexedColors.RED.getIndex();
                break;
            case PRICE_ADJUSTMENT_DECREASE:
                colorIndex = IndexedColors.GREEN.getIndex();
                break;
            default:
                // NO_CHANGE (leave unstyled)
                colorIndex = IndexedColors.WHITE.getIndex();
                break;
        }

        Map<String,Object> cellProps = new HashMap<>();
        cellProps.put(CellUtil.FILL_FOREGROUND_COLOR, colorIndex);
        cellProps.put(CellUtil.FILL_PATTERN, FillPatternType.SOLID_FOREGROUND);

        CellUtil.setCellStyleProperties(cell, cellProps);

    }

}

class PriceListItem {
    public String modelNumber;
    public BigDecimal price;
    public ChangeType changeType;
}

enum ChangeType {
    NO_CHANGE,
    ADDITION,
    DELETION,
    PRICE_ADJUSTMENT_INCREASE,
    PRICE_ADJUSTMENT_DECREASE
}