parentClass{
  [Test]
  testMethod1(){
    login();
    //test things
  }
  [Test]
  testMethod2(){
    login();
    //test other things
  }   
}
[TestSuite]
subclass1()<<parentClass{
  login(){
    //do first type of login
  }
}
subclass2()<<parentClass{
  login(){
    //do second type of login
  }
}