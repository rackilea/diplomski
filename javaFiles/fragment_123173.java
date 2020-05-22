public class MyCustomAdapter extends BaseAdapter {

    private String[] mFirstItems;
    private String[] mSecondItems;
    Context mContext;

    public MyCustomAdapter(String[] firstItems, String[] secondItems, Context context) {
        mFirstItems = firstItems;
        mSecondItems = secondItems;
        mContext = context;
    }

    // Other required overridden methods

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.id.my_row_layout, parent, false);

        // TODO set layout content

        return layout;
    }
}