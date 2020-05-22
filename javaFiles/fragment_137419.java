import java.io.ObjectStreamException;
import java.io.Serializable;

class Person implements Serializable{
   protected String name;
   protected int age;

   Person() {

 }

Person(String name, int age) {
   this.name = name;
   this.age = age;
}
private void readObjectNoData() throws ObjectStreamException {

  name = "cccc";
  age = 1;
  throw new IllegalArgumentException();
 }
}