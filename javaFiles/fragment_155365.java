DefaultTableModel dtm = new DefaultTableModel(new String[] { "Column 1" }, 1);

JTable table = new JTable(dtm) {
@Override
    public Printable getPrintable(PrintMode printMode, MessageFormat headerFormat, MessageFormat footerFormat) {
       return new TablePrintable(this, printMode, headerFormat, footerFormat);
    }
};