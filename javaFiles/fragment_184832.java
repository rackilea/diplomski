for (int i = 0; i < N; i++) {
    final TextView rowTextView = new TextView(MainActivity.this);

    // getting respective string val from list
    rowTextView.setText(" row value #" + al_getAllProductSize.get(i));

    ll_textViewObj.addView(rowTextView);

    // save a reference to the textview for later 
    myTextViews[i] = rowTextView;
}