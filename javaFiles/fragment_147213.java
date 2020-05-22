FileOutputStream fOut = null;
OutputStreamWriter osw = null;
String separator = System.getProperty("line.separator");
try {
    fOut = openFileOutput("sample.txt",MODE_APPEND|MODE_WORLD_READABLE);
    osw = new OutputStreamWriter(fOut);
    osw.write("this is append text");
    osw.write(separator);
    osw.flush();
    osw.close();
} catch (Exception e) {
    Toast.makeText(Ticketing.this,"Error: " + e, Toast.LENGTH_SHORT).show();
    return;