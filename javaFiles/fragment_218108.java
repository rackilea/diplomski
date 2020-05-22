@Override
public View getView(final int position, final View convertView, 
ViewGroup parent) {

    final Holder holder = new Holder();
    LayoutInflater inflater = (LayoutInflater) 
    getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    grid = inflater.inflate(R.layout.smiles_items_layout, null);
    null);

    holder.img = (ImageView) grid.findViewById(R.id.smile_image_view);
    holder.img.setImageResource(mThumbIds[position]);
    holder.img.settag(String.valueof(mThumbIds[position]))


    gridView2.setOnItemClickListener(new 
    AdapterView.OnItemClickListener() {
        Drawable drawable;

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, 
        int i, long l) {
            JSONDictionary imageChat = new JSONDictionary();
            LinearLayout layout= (LinearLayout)view;
            ImageView imageView = (ImageView) layout.getChildAt(0);
            imageView.getDrawable();
            imageChat.put("message", imageView.gettag());
            Communicator.getInstance().emit("new chat message", 
            imageChat);
        }
    });

    return grid;

}