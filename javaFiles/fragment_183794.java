private String getTermsString() {
    StringBuilder termsString = new StringBuilder();
    BufferedReader reader;
    try {
        reader = new BufferedReader(
                new InputStreamReader(getAssets().open("terms.txt")));

        String str;
        while ((str = reader.readLine()) != null) {
            termsString.append(str);
        }

        reader.close();
        return termsString.toString();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}