public class DataStructure{
      private Map<String, A> aMap = new HashMap<String, A>();
      public getA(String name){
          return aMap.get(name);
      }
      public getB(String aName, String bName){
          A anA = getA(aName);
          if(null != anA){
              return anA.getB(bName);
          }else{ 
              return null;
          }
    }
}
public class A{
    String name;
    Map<String, B> myBs = new HashMap<String, B>();
    public A(String name){
        this.name = name;
    }
    public void putB(B foo){
        myBs.put(foo.getName(), foo);
    }
    public B getB(String bName){
        return myBs.get(bName);
    }

 }


public class B{
    String name;
    public B(String name){
        this.name=name;
    }
}