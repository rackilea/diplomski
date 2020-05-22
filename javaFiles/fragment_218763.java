import com.google.gwt.user.cellview.client.CellTable.Style;

public class MyStyle implements Style {

    public static final MyStyle INSTANCE = new MyStyle();

    @Override public boolean ensureInjected() {

        return false;
    }

    @Override public String cellTableCell() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableEvenRow() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableEvenRowCell() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableOddRow() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableOddRowCell() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableFirstColumn() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableFirstColumnFooter() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableFirstColumnHeader() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableFooter() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableHeader() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableHoveredRow() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableHoveredRowCell() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableKeyboardSelectedCell() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableKeyboardSelectedRow() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableKeyboardSelectedRowCell() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableLastColumn() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableLastColumnFooter() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableLastColumnHeader() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableLoading() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableSelectedRow() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableSelectedRowCell() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableSortableHeader() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableSortedHeaderAscending() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableSortedHeaderDescending() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String cellTableWidget() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String getName() {

        return MyCssResource.INSTANCE.myCssClassName();
    }

    @Override public String getText() {

        return MyCssResource.INSTANCE.myCssClassName();
    }
}