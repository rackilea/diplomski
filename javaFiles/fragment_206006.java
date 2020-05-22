enum MyField {
  MY_FIELD1("myField1") {
      public Object getValue(TestObject obj) { return obj.myEnum; }
  },
  MY_FIELD2("myField2") {
      public Object getValue(TestObject obj) { return obj.myInt; }
  },
  ...
  ;

  public abstract Object getValue(TestObject obj);
  public String getName() { return name; }

  public static MyField mapNameToField(String name) { return map.get(name); }

  static {
      map = new HashMap<String,MyField>();
      for(MyField value: values()) {
          map.put(value.getName(), value);
      }
  }

  private MyField(String fieldName) { name = fieldName; }

  private String name;
  private static Map<String, MyField> map;
}