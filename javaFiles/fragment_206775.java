public static void main(String[] args) {
        URLReader reader;
        try {
            reader = new URLReader(new URL("https://celestrak.com/NORAD/elements/resource.txt"));
        BufferedReader bufferedReader = new BufferedReader(reader);
        String sCurrentLine;
        while ((sCurrentLine = bufferedReader.readLine()) != null) {
            System.out.println(sCurrentLine);
        }
        bufferedReader.close();
    } catch (MalformedURLException e1) {
        e1.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}