/**
* Adapter for string based wheel. Highlights the current value.
*/
private class DateArrayAdapter extends ArrayWheelAdapter<String> {
    // Index of current item
    int currentItem;
    // Index of item to be highlighted
    int currentValue;

    /**
    * Constructor
    */
    public DateArrayAdapter(Context context, String[] items, int current) {
        super(context, items);
        this.currentValue = current;
        setItemResource(R.layout.wheelview_textview);
        setItemTextResource(R.id.wheelview_date);
        setTextSize(16);
    }

    protected void configureTextView(CustomTextView view) {
        super.configureTextView(view);
        if (currentItem == currentValue) {
            view.setTextColor(getResources().getColor(R.color.holo_blue));
        }

    }

    @Override
    public View getItem(int index, View cachedView, ViewGroup parent) {
        currentItem = index;
        View view = super.getItem(index, cachedView, parent);
        CustomTextView date = (CustomTextView) view.findViewById(R.id.wheelview_date);
        configureTextView(date);
        return view;
        //return super.getItem(index, cachedView, parent);
    }
}