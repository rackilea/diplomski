public class Main<T extends Foo>{
   public List<T> getFoo();
}

public class SubMain extends Main<SubFoo>{
  public List<SubFoo> getFoo();
}