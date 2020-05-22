class SearchDialog extends Dialog {
    public static final int CANCEL = 1000;
    public static final int SEARCH = 2000;

    private static final String[] choices = { "Search", "Cancel" };
    private static final int[] values = { SEARCH, CANCEL };

    private EditField searchField = new EditField("Address: ", "", 50, EditField.EDITABLE);

    private static Bitmap bmSearch = Bitmap.getBitmapResource("cmd_search.png");

    private SeparatorField separatorField = new SeparatorField(USE_ALL_WIDTH);

    public SearchDialog() {
        super("Search Address", choices, values, SEARCH, bmSearch);

        Manager delegate = getDelegate();
        if (delegate instanceof DialogFieldManager) {
            DialogFieldManager dfm = (DialogFieldManager) delegate;

            Manager manager = dfm.getCustomManager();
            if (manager != null) {
                manager.insert(separatorField, 0);
                manager.insert(new LabelField(), 1);
                manager.insert(searchField, 2);
                manager.insert(new LabelField(), 3);
            }
        }
    }

    public String getSearchKey() {
        return (searchField == null) ? "" : searchField.getText();
    }
}