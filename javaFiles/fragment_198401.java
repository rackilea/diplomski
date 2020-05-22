public class MyAdapter extends ArrayAdapter<Object> {

    //members
    public static class ViewHolder {
        TextView tv;
        ImageView iv;
    }
    private LayoutInflater m_Inflater;
    private ArrayList<Object> m_UnderlyingData;

    // context - context
    // _resource - view defined in xml (will be added to adapter view)
    // itemList - data to fit into view from resource
    public MyAdapter(final Context _context, final int _resource, final ArrayList<Object> _itemList) {    
        super(_context, _resource, _itemList);

        m_Inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        m_UnderlyingData = _itemList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolder oHolder;

        if(convertView == null){
            convertView = m_Inflater.inflate(R.layout.word_item, null);

            // -- remember views that make up the item layout
            oHolder = new ViewHolder();
            oHolder.tv = (TextView) convertView.findViewById(R.id.tv_word);
            oHolder.iv = (ImageView) convertView.findViewById(R.id.iv_icon);

            // -- reference to views that can be accessed outside of this class
            convertView.setTag(oHolder);
        }else{
            oHolder = (ViewHolder) convertView.getTag();
        }

        //set new data
        oHolder.tv.setText((String) m_UnderlyingData.get(position));
        oHolder.iv.setImageResource(R.drawable.icon);

        return convertView;
    }
}