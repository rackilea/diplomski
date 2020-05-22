private TextView[] generatedViews;

private void generateViews(int size) {
    this.generatedViews = new TextView[size];

    for (int i = 0; i < size; ++i) {
        TextView tv = new TextView(this);
        ...
        generatedViews[i] = tv;
    }
}

private void assignListeners() {
    for (TextView tv : generatedViews) {
        tv.setOnClickListener(...);
    }
}