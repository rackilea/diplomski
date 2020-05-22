import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public final class MyMapAdapter extends

   XmlAdapter<MyMapType,Map<Integer, String>> {

   @Override
   public MyMapType marshal(Map<Integer, String> arg0) throws Exception {
      MyMapType myMapType = new MyMapType();
      for(Entry<Integer, String> entry : arg0.entrySet()) {
         MyMapEntryType myMapEntryType =
            new MyMapEntryType();
         myMapEntryType.key = entry.getKey();
         myMapEntryType.value = entry.getValue();
         myMapType.entry.add(myMapEntryType);
      }
      return myMapType;
   }

   @Override
   public Map<Integer, String> unmarshal(MyMapType arg0) throws Exception {
      HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
      for(MyMapEntryType myEntryType : arg0.entry) {
         hashMap.put(myEntryType.key, myEntryType.value);
      }
      return hashMap;
   }

}