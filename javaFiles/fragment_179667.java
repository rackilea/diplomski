public void onCreate()  {
    ObjectGraph objectGraph = ObjectGraph.create(new MyModule());
    Global.objectGraph = objectGraph; //Where global is just a class with a public static field called objectGraph
    MyApp app = objectGraph.get(App.class);
    ...
  }