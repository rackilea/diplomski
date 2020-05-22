@Override
public View getView(int pos, View convertView, ViewGroup parent) 
{
    Arrays.sort(file, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
    final String path = file[position].getAbsolutePath();

    if(convertView == null)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.grid_item, null);
    }

    ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
    ImageView iconPlay= (ImageView) convertView.findViewById(R.id.icon_play);
    TextView textTitle= (TextView) convertView.findViewById(R.id.title);

    // Image
    if (path.endsWith(".jpg") || path.endsWith(".jpeg") || path.endsWith(".png")) {
        Glide
            .with(context)
            .load(file[position])
            .into(imageView);

        // Hide play icon
        iconPlay.setVisibility(View.GONE);
   }

   // Video
   if (path.endsWith(".mp4")) {
        Glide
            .with(context)
            .load(file[position])
            .into(imageView);

        // Show play icon
        iconPlay.setVisibility(View.VISIBLE);
    }

    return convertView;
}