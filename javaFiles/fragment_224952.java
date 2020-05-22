public void MyHandler(object sender, EventArgs args)
 {
     // do stuff
 }
 public void Main(string[] args)
 {
      var foo = new Foo();
      // that method above is the same "shape" as HandlerForBarEvent
      foo.BarEvent += MyHandler;
      foo.CallBar();
 }