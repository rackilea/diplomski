import java.util.*;
import java.util.HashMap;

public class UserImpl implements User {
   HashMap<String, Double> videoRecords = new HashMap<>();

   @Override
   public void updateVideoRecord(String currentVideo, double seconds) {
       videoRecords.put(currentVideo, seconds);
   }

   public HashMap<String, Double> getRecords() {
       return videoRecords;
   }
}