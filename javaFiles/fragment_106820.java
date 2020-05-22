public class CustomArticleAdapter extends BaseAdapter {

    Context context;
    ArrayList<HashMap<String, String>> article;
    LayoutInflater layoutInflater;
    int pageNumber;

    public CustomArticleAdapter(Context context, ArrayList<HashMap<String, String>> article) {
        this.context = context;
        this.article = article;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.pageNumber = 0;   // Initialize the page number with 0
    }

    // Add a method to set the page number in the adapter
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public int getCount() {
        // You need to modify the getCount function to handle the newly introduced pageNumber
        int articleSize = article.size();

        if(10 * pageNumber > articleSize) return articleSize;
        else return 10 * pageNumber;
    }

    // ... Other functions are not needed to be changed
}