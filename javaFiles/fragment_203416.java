public class MyService {

   private static volatile Map<String, Object> map = new HashMap<>();
   private MyDao dao;

   public void refresh(List<Object> objects) {
       Map<String, Object> newMap = new HashMap<>();
       newMap.addAll(dao.findAll()); //maybe long running routine
       map = newMap;
   }

   public Object get(String key) {
       map.get(key); //ensure this waits during a refresh??
   }
}