public class CustomAdapter extends BaseAdapter {

    int rowCount = 1;
    private LayoutInflater inflator;

    public CustomAdapter(Context context) {
        super();
        inflator = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return rowCount;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int postion, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflator.inflate(R.layout.row, parent, false);            
        }
        return convertView;
    }

    public void addRow() {
        rowCount++;
        notifyDataSetChanged();
    }
}