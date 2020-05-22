class ImageAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<HashMap<String, Object>> array;

    public ImageAdapter(Context context) {
        mContext = context;
        array = new ArrayList<>();
    }

    @Override
    public int getCount() {
        Log.v("log", "getcount");
        return array.size();
    }

    public Object getItem(int position) {
        return array.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public void addAll(ArrayList<HashMap<String, Object>> list) {
        array.clear();
        array.addAll(list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub


        //If convertView is null create a new view, else use convert view
        if(convertView==null) {
            Log.v("v", "convertView inflating");
            convertView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate
                    (R.layout.activity_column, null);
        }

        Log.v("convertview", convertView.toString());
        ImageView iv = (ImageView) convertView.findViewById(R.id.ColPhoto);
        iv.setImageBitmap((Bitmap) array.get(position).get(TAG_IMG));
        iv.setVisibility(ImageView.VISIBLE);

        return v;
    }

}