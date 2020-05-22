String clazzname = "foo.bar.Test";
try
{
  Object obj = Class.forName( clazzname ).newInstance();
  //compiler error because java.lang.Object does not contain a method shout()
  obj.shout();
}