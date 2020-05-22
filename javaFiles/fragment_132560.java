public class ListWithImageAdapter extends ArrayAdapter<String>{

    private final Context mContext;
    private final String[] mTexts;

    public ListWithImageAdapter(Context context, String[] texts) {
        super(context, R.layout.list_item_payment_type, texts);
        mContext = context;
        mTexts = texts;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View rowView= LayoutInflater.from(mContext).inflate(R.layout.list_item, null, true);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img); // here you get the image

        return rowView;
    }
}