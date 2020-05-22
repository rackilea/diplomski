import android.util.Log;
  import org.json.*;
  import java.io.*;
  import java.nio.charset.Charset;

  public class TestJsonParse {

      public void test() {
          StringBuffer sb = new StringBuffer();
          sb.append("[ { 'category_id': '334', 'category_name': 'ENGLISH PREMIER LEAGUE VOD', 'parent_id': 0 }, ");
          sb.append("{ 'category_id': '456', 'category_name': 'ENGLISH PREMIER LEAGUE ROCKS', 'parent_id': 2 }]");
          InputStream stream = new ByteArrayInputStream(sb.toString().getBytes(Charset.forName("UTF-8")));
          try {
              convertInputStreamToString(stream);
          } catch (Exception e) {
              Log.e("TestJsonParse", "Issue with stream: "+e);
          }
      }

      /** @return null if errors reading/parsing stream. */
      public String convertInputStreamToString(InputStream stream) throws IOException {

          BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
          StringBuffer sb = new StringBuffer();
          String result = null;
          String line;
          while ((line = bufferedReader.readLine()) != null) {
              sb.append(line);
          }
          //https://stackoverflow.com/questions/1388602/do-i-need-to-close-both-filereader-and-bufferedreader
          bufferedReader.close();

          if (sb.length() > 0) {
              result = sb.toString();
              getinfos(result);
          }
          else {
              Log.e("TestJsonParse"," 404 ");
          }

          return result;
      }


      // Existing 'getinfos' worked as is...
   }