public class MyClass{
   private List<MyObject> lst;

   //Initialization block
   {
       //----Starting initial code-----
       MyAdditionalObject obj=new MyAdditionalObject();
       Event e= new Event()
       obj.attacheEvent(e);
       //----initial code end-----
   }

   public MyClass(){...}

   public MyClass(int i){...}

   public MyClass(String i){...}

}