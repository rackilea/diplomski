addButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        String city= cityAddText.getText().toString();
        String country=countryAddText.getText().toString();
        Intent intent =new Intent();
        intent.putExtra("city",city);
        intent.putExtra("country",country);
        setResult(RESULT_OK, intent);
        finish();
    }
});