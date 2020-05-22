class A implements MyInterface {
    // ...
  }

  public Object decode()
  {
    Gson  gson = builder.registerTypeAdapter(MyInterface.class, new MyInterfaceAdapter());
    MyInterface a =  gson.fromJson(jsonString, MyInterface.class);
  }