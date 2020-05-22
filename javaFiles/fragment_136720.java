public static void main(String[] args) {
    List<MyObject> list = new ArrayList<MyObject>();
    list.add(new MyObject("a","b","c",new BigDecimal(10.23)));
    list.add(new MyObject("a","b","e",new BigDecimal(10.23)));
    list.add(new MyObject("a","b","c",new BigDecimal(10.23)));
    list.add(new MyObject("a","b","d",new BigDecimal(10.23)));
    Map<MyObject,MyObject> map = new HashMap<MyObject,MyObject>(){
       @Override
    public MyObject put(MyObject key, MyObject value) {
           //synchronize if required
        if (containsKey(key)) {
            value.addDouble(get(key).myDouble);
        }
        return super.put(key, value);
    }
    };

 for (MyObject obj:list) {
        map.put(obj, obj);
    }
    for (MyObject obj : map.values())
    System.out.println(obj);
}