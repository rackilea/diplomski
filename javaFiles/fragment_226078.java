TextView textView;
Resources rresources = getResources();
String packageName = getPackageName();

for (int i = 0; i < 6; i++){
    textView = (TextView) findViewById( resources.getIdentifier(String.format("dataTV%d", i), "id", packageName ) )
    if(textView != null)
        textView.setText(data[i]);
}