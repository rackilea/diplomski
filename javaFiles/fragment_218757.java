import com.google.gwt.user.cellview.client.CellTable.Style;

public class MyStyle implements Style {

    public static final MyStyle INSTANCE = new MyStyle();

    @Override public boolean ensureInjected() {

        return false;
    }

    @Override public String cellTableCell() {

        return "myCssClassName";
    }

    @Override public String cellTableEvenRow() {

        return "myCssClassName";
    }

    @Override public String cellTableEvenRowCell() {

        return "myCssClassName";
    }

    @Override public String cellTableOddRow() {

        return "myCssClassName";
    }

    @Override public String cellTableOddRowCell() {

        return "myCssClassName";
    }

    @Override public String cellTableFirstColumn() {

        return "myCssClassName";
    }

    @Override public String cellTableFirstColumnFooter() {

        return "myCssClassName";
    }

    @Override public String cellTableFirstColumnHeader() {

        return "myCssClassName";
    }

    @Override public String cellTableFooter() {

        return "myCssClassName";
    }

    @Override public String cellTableHeader() {

        return "myCssClassName";
    }

    @Override public String cellTableHoveredRow() {

        return "myCssClassName";
    }

    @Override public String cellTableHoveredRowCell() {

        return "myCssClassName";
    }

    @Override public String cellTableKeyboardSelectedCell() {

        return "myCssClassName";
    }

    @Override public String cellTableKeyboardSelectedRow() {

        return "myCssClassName";
    }

    @Override public String cellTableKeyboardSelectedRowCell() {

        return "myCssClassName";
    }

    @Override public String cellTableLastColumn() {

        return "myCssClassName";
    }

    @Override public String cellTableLastColumnFooter() {

        return "myCssClassName";
    }

    @Override public String cellTableLastColumnHeader() {

        return "myCssClassName";
    }

    @Override public String cellTableLoading() {

        return "myCssClassName";
    }

    @Override public String cellTableSelectedRow() {

        return "myCssClassName";
    }

    @Override public String cellTableSelectedRowCell() {

        return "myCssClassName";
    }

    @Override public String cellTableSortableHeader() {

        return "myCssClassName";
    }

    @Override public String cellTableSortedHeaderAscending() {

        return "myCssClassName";
    }

    @Override public String cellTableSortedHeaderDescending() {

        return "myCssClassName";
    }

    @Override public String cellTableWidget() {

        return "myCssClassName";
    }

    @Override public String getName() {

        return "myCssClassName";
    }

    @Override public String getText() {

        return "myCssClassName";
    }
}