public class Table extends AbstractPageElement {

    public Table(WebElement wrappedElement, String name, String page) {
        super(wrappedElement, name, page);
    }

    public static final String ROW_XPATH_LOCATOR = "//tbody/tr";

    private static String getCellXpathLocator(int row, int column) {
        return ROW_XPATH_LOCATOR + "[" + row + "]/td[" + column + "]";
    }

    public int getRowCount() {
        return findAllByXPath(ROW_XPATH_LOCATOR).size();
    }

    public String getCellValue(int row, int column) {
        Cell cell = new Cell(row, column, this.name, this.page);
        return cell.getText();
    }


    public class Cell extends AbstractPageElement {
        private int row;
        private int column;

        public Cell(WebElement wrappedElement, String name, String page) {
            super(wrappedElement, name, page);
        }

        public Cell(int row, int column, String name, String page) {
            super(Table.this.findByXPath(getCellXpathLocator(row, column)), name, page);
            this.row = row;
            this.column = column;
        }

        public String getText() {
            return wrappedElement.getText();
        }

        public Cell nextInRow() {
            return new Cell(row, column + 1, name, page);
        }

        public Cell previousInRow() {
            return new Cell(row, column - 1, name, page);
        }

        public Cell nextInColumn() {
            return new Cell(row + 1, column, name, page);
        }

        public Cell previousInColumn() {
            return new Cell(row - 1, column, name, page);
        }
    }
}