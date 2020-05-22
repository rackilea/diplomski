public class ImagesAdapter extends BaseAdapter {

    private final List<File> imageFiles;

    public ImagesAdapter(List<File> imageFiles) {
        // making a defensive copy of the list
        this.imageFiles = new ArrayList<>(imageFiles);
    }

    public ImagesAdapter(File[] imageFiles) {
        this(Arrays.asList(imageFiles));
    }

    @Override public File getItem(int i) { return imageFiles.get(i); }
    @Override public long getItemId(int position) { return position; }
    @Override public int getCount() { return imageFiles.size(); }

    @Override
    public View getView(int position, View oldView, ViewGroup parent) {
        View view;
        if (oldView == null) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.list_items, parent, false);
        } else {
            view = oldView;
        }

        TextView nameView = (TextView) view.findViewById(R.id.textView1);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);

        File file = imageFiles.get(position);
        nameView.setText(file.getName());

        Uri uri = Uri.fromFile(file);
        Glide.with(view).load(uri).into(imageView);

        return view;
    }
}