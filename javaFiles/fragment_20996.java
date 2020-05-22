public final class FooFactory {
   public IFoo create() {
      if (Connection.speed < 100) //Fictive value
          return new SlowFoo();
      if (Connection.speed < 1000) //Fictive value
          return new MediumFoo();

      return new FastFoo();
   }
}