String[] txtToString() {
    String[] string = new String[10];
    int count = 0;
    try {
        Resources res = getResources();
        InputStream in = res.openRawResource(R.raw.words);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(in));

        String line;

        while ((line = reader.readLine()) != null) {
            string[count] = line;
            count++;
        }

    } catch (Exception e) {
        // e.printStackTrace();

    }
    return string;
}