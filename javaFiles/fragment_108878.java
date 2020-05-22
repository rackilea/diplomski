final String key = "somekey";
count  = getValue(key); //get value from sharedPreference
button = (Button) findViewById(R.id.button);
text = (TextView) findViewById(R.id.textView);
text.setText(String.valueOf(count)); // set it first
button.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {
        count++;
        saveValue(key,count);
        text.setText(String.valueOf(count));
        return false;
    }
});