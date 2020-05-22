public class ImageAdapter extends BaseAdapter {

    private Context mcontext;

    public ImageAdapter (Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mthumbids.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mcontext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);

            // Add the following to load the image
            imageView.setBackground(ContextCompat.getDrawable(context, mthumbids[position]));
        }
        else  {
            imageView = (ImageView)convertView;
        }

        return imageView;
    }

    private Integer[] mthumbids =
            {
              R.drawable.img1, R.drawable.img2,
              R.drawable.img3, R.drawable.img4,
              R.drawable.img5, R.drawable.img6
            };
}