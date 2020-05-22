public class Test {

    public static void main(String[] args) {
        StringBuilder contentBuilder = new StringBuilder();

        InputStream is = Test.class.getResourceAsStream("/test.html");
        try {
            String sCurrentLine;

            BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
            while ((sCurrentLine = buffer.readLine())!=null)
                contentBuilder.append(sCurrentLine);
            buffer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        System.out.println("content=" + contentBuilder.toString());
    }
}