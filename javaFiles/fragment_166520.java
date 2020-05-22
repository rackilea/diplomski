interface MyService {

   Foo getFoo(Bar bar); 

   void setFoo(Foo foo);// letting GWT know that we might send Foo object over the wire, you don't have to ever call this method in your app, or implement it in some meaningful way, just let it be there

}