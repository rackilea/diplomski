@Override
public View getView(final int position, View convertView, ViewGroup parent)
{
    ViewHolder holder;
    if (convertView == null) {
       LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_create_product_gridview_normal, parent, false);
        //Set up viewholder
        holder = new ViewHolder();
        holder.productImageIv = (ImageView) convertView.findViewById(R.id.android_gridview_image);
        holder.addImageIb = (ImageButton) convertView.findViewById(R.id.addImageButton);
        holder.removeImageIb = (ImageButton) convertView.findViewById(R.id.removeImageButton);

        // set click listener here.
        // don't use runOnUiThread for click listener.

        // bind the view here.

        convertView.setTag(holder);
    } else {
       holder = (ViewHolder) convertView.getTag();
    }

    // set the value for view here
    holder.productImageIv.setImageBitmap(images[position]);


    return convertView;
}