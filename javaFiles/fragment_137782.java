public static String[] getAdbLogCat() {

    try {
        Process p = Runtime.getRuntime().exec("/path/to/adb shell logcat");
        InputStream is = p.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        final StringBuffer output = new StringBuffer();
        String line;
        ArrayList<String> arrList = new ArrayList<String>();
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        return (String[])arrList.toArray(new String[0]);
    } catch (IOException e) {
        System.err.println(e);
        e.printStackTrace();
        return new String[]{};
    }
}