import java.io.InputStream;
import java.util.*;

public class MapList {
   public static void main(String[] args) {
      Map<String, List<String>> mapList = new HashMap<String, List<String>>();

      String sourcePath = "MapListData.txt";
      InputStream source = MapList.class.getResourceAsStream(sourcePath);
      if (source == null) {
         return;
      }
      Scanner scan = new Scanner(source);
      while (scan.hasNextLine()) {
         String line = scan.nextLine().trim();
         if (!line.isEmpty()) {
            line = line.replace(";", "");
            String[] mainTokens = line.split("\\s*:\\s*");
            if (mainTokens.length == 2) {
               String key = mainTokens[0];
               List<String> list = new ArrayList<String>();
               String[] subTokens = mainTokens[1].split("\\s+");
               for (String subToken : subTokens) {
                  list.add(subToken);
               }
               mapList.put(key, list);
            }
         }
      }

      if (scan != null) {
         scan.close();
      }

      for (String key : mapList.keySet()) {
         List<String> list = mapList.get(key);

         System.out.printf("%s: %s%n", key, list);
      }
   }
}