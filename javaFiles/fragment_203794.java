TextView title = null, darkThemeTitle = null;

TextView[] textViews = {title, darkThemeTitle};
Integer[] ids = {R.id.title, R.id.darkThemeTitle};

for (int i = 0; i < textViews.length; i++) {
    textViews[i] = (TextView) findViewById(ids[i]);
}