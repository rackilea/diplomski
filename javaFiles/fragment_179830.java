void f()
{
  if(true) 
      throw new Error();

  class InnerClass
  { 
    ... 
  }
}