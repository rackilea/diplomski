public class Test01 {
public static void main(String[] args) {
    ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
    HashMap<String, Object> map=new HashMap<String, Object>();
    map.put("test_key", "test_value");
    data.add(map);
    HashMap hashMap = data.get(0);
    Iterator<Object> iterator=hashMap.entrySet().iterator();
    while(iterator.hasNext()){
        Map.Entry<String, Object> entry=(Entry<String, Object>) iterator.next();
        System.out.println("Key :"+entry.getKey()+" Value : "+entry.getValue());
    }

}