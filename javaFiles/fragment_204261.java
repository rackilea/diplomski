Public Class Student implements KvmSerializable{

private int age;
private String name;

public Student(){}

public Student(int age, String name){
   this.age = age;
   this.name = name;
  }
  //setter and getter methods come here.
  //...

  public Object getProperty(int arg0) {
      switch(arg0){
      case 0: 
          return getAge();
      case 1:
          return getName();
      }
      return null;
  }

  public int getPropertyCount() {
      return 2;
  }

  public void setProperty(int index, Object value) {
      switch(index){
      case 0 :
         age = value.toString();
         break;
      case 1 :
         name = value.toString();
         break;
      default:
         break;
      }
  }
}