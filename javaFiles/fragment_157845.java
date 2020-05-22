public void WriteValue (View sender) {
    Button bt = (Button)sender;
    if(bt.getId() == R.id.clearButtonId) {
        Display.setText("0");
    }
}