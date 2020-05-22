button = (Button)findViewById(R.id.button);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        int clicks = 0;
        clicks++;

        if (clicks >= 5){
            button.setEnabled(false);
        }

        SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", this.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("clicks", clicks);
        editor.apply();
    }
});