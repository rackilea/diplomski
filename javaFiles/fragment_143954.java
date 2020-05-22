public class TestClass{
      public TestClass(){
      }

      //copy constructor
      public TestClass( TestClass copy){
         this.list = new ArrayList<Integer>(copy.list);
         this.count = copy.count;
      }

      ...
 }