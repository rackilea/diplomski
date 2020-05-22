...
textToUse = companyAddress.getText().toString();
textToUse = textToUse.replace(' ', '+');
// begin inserted code
if (textToUse.length() == 0) {
    Toast.makeText(this, "Please Enter Address", Toast.LENGTH_SHORT).show();
    return;
}
// end inserted code
try {
    Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + textToUse));
    startActivity(geoIntent);
} catch (Exception e){
    Toast.makeText(this, getString(R.string.maps_error), Toast.LENGTH_SHORT).show();
}
...