public class Person {

    String name;
    Person(String str){
        name = str;
    }

    @Override
    public String toString() {
      return name;
    }

}