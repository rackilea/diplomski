public class Student{
       String name;
       int roll;
       int standard;
       public Student setName(String n){ this.name =n; return this;}
       public Student setRoll(int n){ this.roll =n; return this;}
       public Student setStandard(int n){ this.standard =n; return this}
      public int getFees(){
           return standard*2;
      }
}
...
public void someMethod(Student s){

 Int fees = s.setName("KK").setRoll(30).setStandard(10).getFees();
  // Other lines of code ..
 }