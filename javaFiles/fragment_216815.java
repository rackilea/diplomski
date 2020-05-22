import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
....

Map<String,String> mMap = new HashMap<String, String>();
mMap.put("key", "something");
Iterator iter = mMap.entrySet().iterator();
while (iter.hasNext()) {
    Map.Entry mEntry = (Map.Entry) iter.next();
    System.out.println(mEntry.getKey() + " : " + mEntry.getValue());
}