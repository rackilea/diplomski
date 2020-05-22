countryButton.setOnClickListener(new OnClickListener(){

@Override
public void onClick(View v) {

    final ArrayAdapter<CharSequence> countryAdapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.countries_array, android.R.layout.simple_spinner_item);

    new AlertDialog.Builder(MakeQuestion.this)
    .setTitle("Country")
    .setAdapter(countryAdapter, new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
        String countryResult = countryAdapter.getItem(which);//use this getItem() method
        countryButton.setText(countryResult);
        dialog.dismiss();
        }
        }).create().show();
}

});