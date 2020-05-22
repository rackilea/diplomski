class LiteratureAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;
    LayoutInflater inflater=null;
    public ProductImageLoader imageLoader; 
    String adapter_for;
    int loader1;
    int selected = -1; // by default nothing is selected

    public LiteratureAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
        //get_orientation = orientation;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ProductImageLoader(activity.getApplicationContext());
    }

    public int getCount() {
        if(null == data){ 
            return 0;
        }else{
            return data.size();
        }
    }

    public HashMap<String, String> getItem(int position) {
        if(null == data){
            return null;
        }else{
            return data.get(position);
        }
    }

    public long getItemId(int position) {
        return position;
    }
    public class ViewHolder {
       TextView title;
       CheckBox check_lit;
       LinearLayout quantity_selection;
       ImageView thumb_image;
       HashMap<String, String> song;
       String can_order;
       EditText quantity_lit;
       String quantity;
       CheckBox cb;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;

        if(convertView==null){
            viewHolder = new ViewHolder();

            convertView = inflater.inflate(R.layout.literature_items_port, null);
            viewHolder.quantity_lit = (EditText)convertView.findViewById(R.id.quantity_lit);

            viewHolder.title = (TextView)convertView.findViewById(R.id.catalog_name); // title
            viewHolder.quantity_selection = (LinearLayout)convertView.findViewById(R.id.quantity_selection);
            viewHolder.check_lit = (CheckBox)convertView.findViewById(R.id.check_lit);
            viewHolder.thumb_image=(ImageView)convertView.findViewById(R.id.literature_image); // thumb image

            //ScrollView cat_scroll_list = (ScrollView)convertView.findViewById(R.id.cat_scroll_list);
            viewHolder.song = new HashMap<String, String>();
            viewHolder.check_lit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {    

                    if(isChecked){                    
                        String sPos = (String)buttonView.getTag();
                        int iPos = Integer.parseInt(pos);
                        if(selected != iPos){
                            selected = iPos;
                            //new Item got selected do your work here
                            Toast.makeText(a.getApplicationContext(), "User selected: "+ iPos, Toast.LENGTH_LONG).show();
                            LiteratureAdapter.this.notifyDataSetChanged();
                        }
                    }
                }
            });
            convertView.setTag(viewHolder); 

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }   
        //retain the checked state
        if(position == selected){
            viewHolder.check_lit.setChecked(true);
        }else{
            viewHolder.check_lit.setChecked(false); //needs to be reset
        }

        viewHolder.check_lit.setTag(""+position);

        viewHolder.song = getItem(position);

        viewHolder.title.setText(viewHolder.song.get(LiteratureList.CATEGORY_NAME));
        imageLoader.DisplayImage(viewHolder.song.get(LiteratureList.LARGE_IMAGE),loader1, viewHolder.thumb_image);
        viewHolder.thumb_image.setScaleType(ScaleType.FIT_XY);

        return convertView;
    }
}