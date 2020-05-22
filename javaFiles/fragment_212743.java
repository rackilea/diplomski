public void invoker(){
    Student s = new Student();       
    promoteStudent(s);
 }
public void promoteStudent(Student s){
     s.standard++;
     // No need to return the object reference as same object has been modified and reference of the same is present with the invoker.
}

public class Student{
    int standard = 1;
}