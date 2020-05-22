btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        spinnergipfeli.setSelection(prefs.getInt("spinnerSelection", 0));
        Context context = getApplicationContext();
        String text = prefs.getString("thetime", "default empty value");
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
});