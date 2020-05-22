class CenteredOverrunTableCell extends TableCell<Person, String> {
    public CenteredOverrunTableCell() {
        this(null);
    }

    public CenteredOverrunTableCell(String ellipsisString) {
        super();
        setTextOverrun(OverrunStyle.CENTER_WORD_ELLIPSIS);
        if (ellipsisString != null) {
            setEllipsisString(ellipsisString);
        }  
    }

    @Override protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setText(item == null ? "" : item);
    }
}