<!-- language: lang-java -->
public static void main(String[] args) {
    HashMap<String, Integer> hMap = new HashMap<String, Integer>();
    hMap.put("Hi1", new Integer(1));
    hMap.put("Hi2", new Integer(2));
    hMap.put("Hi3", new Integer(3));
    hMap.put("Hi4", new Integer(4));
    Set set = hMap.entrySet();
    Iterator i = set.iterator();
    while(i.hasNext()){
        Map.Entry me = (Map.Entry)i.next();
        System.out.println(me.getKey().getClass().getName() + " : " + me.getValue().getClass().getName() );
        System.out.println(me.getKey() + " : " + me.getValue() );
    }
}