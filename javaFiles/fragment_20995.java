public interface IFoo {
   void connect();
}

final class SlowFoo implements IFoo {
  //Implementation for slow connections
} 

final class MediumFoo implements IFoo {
  //Implementation for medium connections
} 

final class FastFoo implements IFoo {
  //Implementation for fast connections
}