class ParentClass{
 void m1(){
   System.out.println("parent m1");
  }
 void m2(){
   System.out.println("parent m2");
  }
}

class SubClass extends ParentClass{
//subclass overriding parent class m1 method
 @Override
 void m1(){
   System.out.println("child m1");
  }
 void m3(){
   System.out.println("child m3");
  }
}

class Test{
public static void main(String[] args){
  ParentClass p = new SubClass();
  p.m1();// out puts child m1 as child class is overriding m1 method
  p.m2();//out puts parent m2 as child class is not overriding m2 method
  p.m3();//gives compile time error as parent class reference doesn't know about m3 method

}
}