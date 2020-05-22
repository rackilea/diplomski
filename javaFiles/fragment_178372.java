public class MyAdapter extends SimpleAdapter{

  public MyAdapter(Context context, List<? extends Map<String, ?>> data, int     resource, String[] from, int[] to){
  super(context, data, resource, from, to);
  }

   public View getView(int position, View convertView, ViewGroup parent){
  // here you let SimpleAdapter built the view normally.
  View v = super.getView(position, convertView, parent);

   // Then we get reference for Picasso
  ImageView img = (ImageView) v.getTag();
  if(img == null){
     img = (ImageView) v.findViewById(R.id.imageOrders);
     v.setTag(img); // <<< THIS LINE !!!!
  }
  // get the url from the data you passed to the `Map`
  String url = ((Map)getItem(position)).get(TAG_IMAGE);
  // do Picasso
  // maybe you could do that by using many ways to start

    Picasso.with(context).load(url)
            .resize(imageWidth, imageWidth).into(img);

  // return the view
  return v;
   }
}