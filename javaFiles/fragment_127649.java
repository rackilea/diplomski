public static void main(String[] args) throws Exception {
  Map<MyWrapper, String> map = new HashMap<MyWrapper, String>();
  MyWrapper wrapper = new MyWrapper(1);
  map.put(wrapper, "hello");
  System.out.println(map.containsKey(wrapper));
  wrapper.setI(2);
  System.out.println(map.containsKey(wrapper));
}