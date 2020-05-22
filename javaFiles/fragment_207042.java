@Override
public View getView(int i, View view, ViewGroup viewGroup) {
    View v = view;
    ImageView picture;

    ....
    ....

    LayerDrawable ld = new LayerDrawable(new Drawable[] 

                           // Drawable from item
                           { getResources().getDrawable(item.drawableId), 

                           // Selector
                           getResources().getDrawable(R.drawable.selector)});

    // Set the LayerDrawable
    picture.setImageDrawable(ld);

    // Don't need this
    // picture.setBackgroundResource(R.drawable.selector);

    return v;
}