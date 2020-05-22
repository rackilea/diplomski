Button b = (Button) findViewById(R.id.button4);
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        ...
        if (prefs.contains(code)) {
            ...
            AlertDialog alert = builder.create();
            alert.show();
        }else{
            editor.putString(code, name);
            editor.apply();
        }
    }
});