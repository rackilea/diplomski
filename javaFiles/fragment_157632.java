public class URLConnectionReader {
    public static void main(String[] argv) {
      try {
        URL phpUrl = new URL("http://server/myphp.php");
        URLConnection urlCon = phpUrl.openConnection();
        BufferedReader br = new BufferedReader(
                                new InputStreamReader(
                                urlCon.getInputStream()));
        String line;

        while ((line = br.readLine()) != null) 
            System.out.println(line);
        br.close();
      } catch(Exception e) {
        // handle errors here...
      }
    }
}