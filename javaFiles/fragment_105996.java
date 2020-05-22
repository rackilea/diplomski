public class ProductSearchAction extends ActionSupport implements Preparable {
    private List<String> categories;
    private String chosenCategory;

    @override
    public void prepare() throws Exception {      
        categories = new ArrayList<String>();
        categories.add("Eins");
        categories.add("Zwei");
        categories.add("Drei");
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    /* GETTERS AND SETTERS */
}