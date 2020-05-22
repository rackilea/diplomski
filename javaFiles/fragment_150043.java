class Foo {
   public EventListener<X> asXListener() {
      return new EventListener<X>() {
          // code here can refer to Foo
      };
   }


  public EventListener<Y> asYListener() {
      return new EventListener<Y>() {
          // code here can refer to Foo
      };
   }
}