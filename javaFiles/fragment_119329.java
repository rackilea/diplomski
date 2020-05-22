ArrayList<String> words = new ArrayList<String>();
words.add("One");
words.add("Two");
words.add("Three");
words.add("Four");
words.add("Five");
words.add("Six");
words.add("Seven");
words.add("Eight");
words.add("Nine");
words.add("Ten");
LinearLayout routeView = (LinearLayout) findViewById(R.id.routeView);
for (int i = 0; i < words.size(); i++) {
    TextView wordView = new TextView(this);
    wordView.setText(words.get(i));
    routeView.addView(wordView);
}