import java.io.*;
import java.util.*;

class Tree {

    String val;
    Tree[] children;

    public Tree(String val, Tree... children) {
        this.val = val;
        this.children = children;
    }
}


class Cell {
    String val;
    int row, col, rowspan, colspan;
    public Cell(String val, int row, int col, int rowspan, int colspan) {
        this.val = val;
        this.row = row;
        this.col = col;
        this.rowspan = rowspan;
        this.colspan = colspan;
    }

    public String asTdTag() {
        String cs = colspan == 1 ? "" : " colspan='" + colspan + "'";
        String rs = rowspan == 1 ? "" : " rowspan='" + rowspan + "'";
        return "<td" + cs + rs + ">" + val + "</td>";
    }
}


public class TreeTest {

    public static int rowsToUse(Tree t) {
        int childrenRows = t.children.length == 0 ? 0 : 1;
        for (Tree child : t.children)
            childrenRows = lcm(childrenRows, rowsToUse(child));
        return 1 + childrenRows;
    }


    public static List<Cell> getCells(Tree t, int row, int col, int rowsLeft) {

        // Add top-most cell corresponding to the root of the current tree.
        int rootRows = rowsLeft / rowsToUse(t);
        List<Cell> cells = new ArrayList<Cell>();
        cells.add(new Cell(t.val, row, col, rootRows, width(t)));

        // Generate cells for subtrees.
        for (Tree child : t.children) {
            cells.addAll(getCells(child, row+rootRows, col, rowsLeft-rootRows));
            col += width(child);
        }

        return cells;
    }


    public static int width(Tree t) {
        if (t.children.length == 0)
            return 1;
        int w = 0;
        for (Tree child : t.children)
            w += width(child);
        return w;
    }


    public static int lcm(int a, int b) {
        int c = a * b;
        while (b > 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return c / a;
    }


    public static String getHtmlTable(List<Cell> cells) {

        // Sort the cells primarily on row, secondarily on column.
        Collections.sort(cells, new Comparator<Cell>() {
            public int compare(Cell c1, Cell c2) {
                int pri = Integer.valueOf(c1.row).compareTo(c2.row);
                int sec = Integer.valueOf(c1.col).compareTo(c2.col);
                return pri != 0 ? pri : sec;
            }
        });

        // Lay out the cells row by row.
        StringBuilder result = new StringBuilder("<table><tbody>");
        for (int row = 0, i = 0; i < cells.size(); row++) {
            result.append("<tr>\n");
            for (; i < cells.size() && cells.get(i).row == row; i++)
                result.append("  " + cells.get(i).asTdTag() + "\n");
            result.append("</tr>\n");
        }
        return result.append("</tbody></table>").toString();
    }


    public static void main(String[] args) throws IOException {

        Tree t = new Tree("1",
                new Tree("2",
                  new Tree("4"),
                    new Tree("5",
                      new Tree("8"),
                      new Tree("9"))),
                new Tree("3",
                  new Tree("6"),
                  new Tree("7")));

        FileWriter fw = new FileWriter("tree.html");

        List<Cell> cells = getCells(t, 0, 0, rowsToUse(t));

        fw.write("<html><head><style>table, td { border-style: solid; } " +
                 "table { border-spacing: 0px; border-width: 0 0 1px 5px; } " +
                 "td { padding: 15px; text-align: center; " +
                 "border-width: 1px 5px 0 0;} </style></head><body>");
        fw.write(getHtmlTable(cells));
        fw.write("</body></html>");

        fw.close();
    }
}