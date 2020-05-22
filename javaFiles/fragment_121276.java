public class MainClass<T extends Object> {
      public Class<T> myType;

      public MainClass(Class<T> type) {
        myType = type;
      }
      public void myMethod(T myParameter) {
        // Do stuff
      }
}

class ChildClass extends MainClass<String> {
      public ChildClass() {
        super(String.class);
        // this should be changeable to what ever class then String.class
      }
}