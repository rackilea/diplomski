try {
    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE); 
    fos.write(("0").getBytes());
    fos.close();
} catch (Exception e) {
    e.printStackTrace();
}