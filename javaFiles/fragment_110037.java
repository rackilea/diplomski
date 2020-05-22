@Override
public View getView(int position, View convertView, ViewGroup parent) {

    View vi = convertView;
    if (convertView == null)
        vi = lif.inflate(R.layout.inflate, null);
    imageView = (ImageView) vi.findViewById(R.id.imageForImageView);

    TextView pizza_title = (TextView) findViewById(R.id.text_food_title);
    pizza_title.setText("Your text");

    final Typeface pizza_title_font  = Typeface.createFromAsset(getAssets(),"pizza.ttf");
    pizza_title.setTypeface(pizza_title_font);

    return vi;
}