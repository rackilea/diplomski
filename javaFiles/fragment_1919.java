private char[] readWholeFile(String file) {
    Context ctx = ApplicationContextProvider.getContext();
    int resId = ctx.getResources().getIdentifier(file, "raw", ctx.getPackageName());
    InputStream inputStream = ctx.getResources().openRawResource(resId);

    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream), 8192);
    try {
        int length = inputStream.available();
        char[] contents = new char[length];
        reader.read(contents, 0, length);
        return contents;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    } finally {
        try {
            if (reader != null) reader.close();
        } catch (Exception e) {

        }
    }
}


public List<String> readEntries() {
    final int EXPECTED_ELEMENTS = 24500;

    char[] contents = readWholeFile("somefile");
    if (contents == null) {
        return new ArrayList<String>();
    }
    List<String> entries = new ArrayList<String>(EXPECTED_ELEMENTS);
    String test;
    BufferedReader reader = new BufferedReader(new CharArrayReader(contents));
    try {
        while ((test = reader.readLine()) != null) {
            entries.add(test);
        }
        return entries;
    } catch (IOException e) {
        e.printStackTrace();
        return new ArrayList<String>();
    } finally {
        try {
            if (reader != null) reader.close();
        } catch (Exception e) {

        }
    }
}