} else if (options[item].equals("Cancel")) {
   dialog.dismiss();
   Intent returnIntent = new Intent();
   returnIntent.putExtra("text", YOUR_STRING_HERE);
   setResult(Activity.RESULT_CANCELED, returnIntent);
   finish();

}