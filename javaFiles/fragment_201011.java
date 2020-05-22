int selected = 0; // set selected to index of what is selected
File file = new File(Environment.getExternalStorageDirectory(), //folder location where you store the files
titles[selected]+".xml"); //in case of xml files. If other types, you'll need to add case for diff types
Uri path = Uri.fromFile(file);
Intent fileOpenintent = new Intent(Intent.ACTION_VIEW);
fileOpenintent .setDataAndType(path, "application/xml"); //for xml MIME types are text/xml and application/xml
try {
    startActivity(fileOpenintent);
}
catch (ActivityNotFoundException e) {

}