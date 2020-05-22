ImageView imageItem1;
String[] separated = result.toString().replace("[", "").replace("]", "").split(",");
for (int i = 0; i < 3; ++i) {
    // Create new ImageView
    imageItem1 = new ImageView(this);

    // Set the shadow background
    imageItem1.setBackgroundResource(R.drawable.shadow);

    String scrubbedURL = separated[j].trim();
    ...
    ++j;
}