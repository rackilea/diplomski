public class ImageAdapter extends BaseAdapter {

    /** LayoutInflater. */
    private LayoutInflater mInflater;

    /** The i. */
    private ImageView i;

    /**
     * Instantiates a new image adapter.
     * 
     * @param c
     *            the c
     */
    public ImageAdapter(Context c) {
        mInflater = LayoutInflater.from(c);
    }

    public int getCount() {
                    // scaled pictures will have the list of
                    // which you have from the directory
        return scaledPictures.size();
    }

    public Bitmap getItem(int position) {
        return scaledPictures.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
        convertView = mInflater.inflate(R.layout.image, parent, false);
        } else {
            i = (ImageView) convertView;
        }

        Bitmap bitmap = getItem(position);
        i = (ImageView) convertView.findViewById(R.id.galleryimage);
        i.setImageBitmap(bitmap);
        bitmap = null;

        return i;
    }
}