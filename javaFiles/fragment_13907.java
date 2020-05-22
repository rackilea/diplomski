public class ImageAdapter extends PagerAdapter {

private ImageView imageView;
private Context context;
private LayoutInflater inflater;
private ArrayList<String> listOfAllImages = new ArrayList<>();

public ImageAdapter(Context context) {
    this.context = context;
    getAllShownImagesPath();
}


@Override
public int getCount() {
    return listOfAllImages.size();
}

@Override
public boolean isViewFromObject(View view, Object object) {
    return view == object;
}

@Override
public Object instantiateItem(ViewGroup container, int position) {
    inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View view = inflater.inflate(R.layout.photopager, null);
    imageView = (ImageView) view.findViewById(R.id.photoView2);

    Glide.with(context).load(listOfAllImages.get(position))
            .thumbnail(1f)
            .crossFade()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageView);

    ViewPager viewPager = (ViewPager) container;
    viewPager.addView(view, 0);
    return view;
}

@Override
public void destroyItem(ViewGroup container, int position, Object object) {
    ViewPager vp = (ViewPager) container;
    View view = (View) object;
    vp.removeView(view);
}

private void getAllShownImagesPath() {
    Uri uri;
    Cursor cursor;
    int column_index_data;
    String absolutePathOfImage;
    uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

    String[] projection = {MediaStore.MediaColumns.DATA,
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME};

    cursor = context.getContentResolver().query(uri, projection, null,
            null, null);

    column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
    while (cursor.moveToNext()) {
        absolutePathOfImage = cursor.getString(column_index_data);
        listOfAllImages.add(absolutePathOfImage);
    }

    cursor.close();
}
}