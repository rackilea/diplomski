public class ArrayOfFoo {
     Object [] ary;  // ctor left as exercise

     public void set(int index, Foo value){
         ary[index] = (Object) value; // cast strictly not needed, any Foo is an Object
     }
     public void get(int index){
         return (Foo) ary[index];     // cast needed, not every Object is a Foo
     }
 }