if (requestCode == WRITE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
    Uri uri = resultData.getData();

    try {
        OutputStream os=getContentResolver().openOutputStream(uri);
        PrintStream ps=new PrintStream(os);
        ps.print("Message to write");
        ps.flush();
        ps.close();
    } catch (Exception e) {
        Log.e("Some identifying string", "Exception writing to "+uri.toString(), e);
    }
}