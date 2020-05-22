public class ListViewAdapters extends BaseAdapter {

    ArrayList<HashMap<String, String>> origList = new ArrayList<>();

    public ListViewAdapters(Activity activity,ArrayList<HashMap<String, String>> list) {
        super();
        this.activity=activity;
        this.list=list;
        this.origList=list;
    }

    ...

    void filter(String filterString) {
        list = new ArrayList<>();
        for (HashMap<String, String> item: origList) {
            // use your own logic to filter
            if (itemShouldBeAdded)
                list.add(item); // add if item is inside filter
        }
        notifyDataSetChanged();
    }

    void cancelFilter() {
        list = origList;
        notifyDataSetChanged();
    }

}