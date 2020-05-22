public interface SomeInterface{
   public void mymeth();
}

class MyClass implements SomeInterface{

   public void mymeth(){

   }
}

//is in the same package as MyClass
public MyClassFactory{
   public SomeInterface create(/*parameters*/){
       //create instance from parameters
       //For your case
       MyClass instanceOfAnyClassThatImplementsSomeInterface = new MyClass(/*pass the parameters*/); 
       return instanceOfAnyClassThatImplementsSomeInterface;
   }
}