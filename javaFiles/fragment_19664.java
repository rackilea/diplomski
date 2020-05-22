Class A{

public void method1()
{
 synchronized(this)//Block 1 taking lock on Object
 {
  //do something
 }
}

public void method2()
{
 synchronized(this)//Block 2 taking lock on Object
 {
  //do something
 }
}
}