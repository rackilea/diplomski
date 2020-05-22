abstract class Base {
  public String ID;
  public Object Name;
}

class A extends Base {
}

class B extends Base {
}

public void SomeMethod(Base arg)
{
  String id = arg.ID;
  Object name= arg.Name;
}