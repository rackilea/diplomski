String clazzname = "foo.bar.Test";
try
{
  foo.bar.Test obj = (foo.bar.Test)Class.forName( clazzname ).newInstance();
  // does work now since obj is now treated as a 'Test' object.
  obj.shout();
}