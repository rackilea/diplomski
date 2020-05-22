protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("myText", conver_textview_to_string);
    }

protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    conver_textview_to_string = savedInstanceState.getParcelableArrayList("myText");    
}