//Example of super()
class parent
{
  parent()
  {

  }
}
class child()
{
   child()
   {
      super();   //Go to parent class constructor
   }
}


//Example of this    
class test
{
    test()
    {
       this("a");  //go to test one argument constructor within the test class
    }
    test(String a)
    {

    }

}