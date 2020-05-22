LinearLayout parentLayout = (LinearLayout) findViewById(R.id.parentLayout);

int num_textViews = 10; // number of textViews you might want in your ArrayList
ArrayList<TextView> arrayList = new ArrayList<>();

for (int i = 0; i < num_textViews; i++) {
    TextView tv = new TextView(this);
    tv.setText((i + 1) + "");
    // add any styling you wish

    arrayList.add(tv);
    parentLayout.addView(tv);
}