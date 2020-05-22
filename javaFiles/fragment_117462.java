public class CustomListAdapter extends ArrayAdapter<Spells> {

    Context mContext;
    int layoutResourceId;
    CustomObject data[] = null;
    private String property;
    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context mContext, int layoutResourceId, CustomObject[] customObjects){
        super (mContext, layoutResourceId, magias);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = customObjects; 
    }


    public View getView(int position, View convertView, ViewGroup parent){
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        CustomObject object = data[position];

        TextView textViewItem = (TextView) convertView.findViewById(R.id.textViewItem);
        textViewItem.setText(object.getName());

        return convertView;
    }

}