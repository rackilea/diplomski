@Override
public void onBackPressed() {
 Intent returnIntent = new Intent();
 returnIntent.putExtra("text", YOUR_STRING_HERE);
 setResult(Activity.RESULT_CANCELED, returnIntent);
 finish();
}