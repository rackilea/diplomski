public class ImageAdapter extends BaseAdapter
{
    private Context context;
    private int itemBackground;
    Integer[] local_imageIDs
    public ImageAdapter(Context c, Integer[] local_imageIDs)
    {
        context = c;
        this.local_imageIDs = local_imageIDs;
        //---setting the style---
        TypedArray a = obtainStyledAttributes(R.styleable.Gallery1);
        itemBackground = a.getResourceId(
        R.styleable.Gallery1_android_galleryItemBackground, 0);
        a.recycle();
    }

    //---returns the number of images---
    public int getCount()
    {
        return local_imageIDs.length;
    }

    //---returns the ID of an item---
    public Object getItem(int position)
    {
        return position;
    }

    public long getItemId(int position)
    {
        return position;
    }

    //---returns an ImageView view---
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(local_imageIDs[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new Gallery.LayoutParams(150, 120));
        imageView.setBackgroundResource(itemBackground);
        return imageView;
    }   
}