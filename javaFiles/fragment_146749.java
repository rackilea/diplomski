public class ItemListAdapter extends ArrayAdapter<CustomListItem>{
    private Context context;
    private List<CustomListItem> data;

    public ItemListAdapter(Context context, List<CustomListItem> data){
        this.context = context;
        this.data = data;
    }
}