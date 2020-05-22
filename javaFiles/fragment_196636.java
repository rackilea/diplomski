@Override
public View getView(int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub

LayoutInflater inflater = (LayoutInflater) mContext
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

View view;

if(position == 0)
// Populate default item
else
// Populate from json
if(convertView == null){
    view = new View(mContext);
    view = inflater.inflate(R.layout.grid_item_text, null);

    TextView personName = (TextView) view.findViewById(R.id.textItem);
    ImageView personThumb = (ImageView) view.findViewById(R.id.iconItem);

    // IF HAVE RESULT
    if(mList.size() != 0){
        /* INITIALIZES PHOTO */
        BitmapFactory.Options bmOptions;
        bmOptions = new BitmapFactory.Options();
        bmOptions.inSampleSize = 1;

        /*
        Bitmap bmpThumb = loadBitmap(mList.get(position).accId, bmOptions, IMAGE_THUMB);

        if(bmpThumb != null){
            ImageHelper ih = new ImageHelper();
            bmpThumb = ih.getRoundedCornerBitmap(bmpThumb, 10);
            personThumb.setImageBitmap(bmpThumb);
        }else{
            personThumb.setImageResource(mThumbs);
        }
        */

        personThumb.setImageResource(mThumbs);
        personName.setText(mList.get(position).fullName.toString());
    }else{
        personThumb.setImageResource(mThumbs);
        personName.setText("Add Friends");
    }



}else{
    view = (View) convertView;
}
return view;