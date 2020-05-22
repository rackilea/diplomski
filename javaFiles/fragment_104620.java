String folderPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/CalendarNote/" + dateN;
File folder = new File(folderPath);

boolean success = true;
if (!folder.exists()) {
    success = folder.mkdirs();
}

if (success) {
    Toast.makeText(getBaseContext(), "You have successfully created." , Toast.LENGTH_LONG ).show();
    Intent w = new Intent(DatePickerActivity.this, SelectTypeActivity.class);
    w..putExtra("folderpath", folderPath);
    startActivity(w);

} else {
    Toast.makeText(getBaseContext(), "You have Failed to create." , Toast.LENGTH_LONG ).show();
}