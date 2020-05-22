class Main extends Activity{
   @override
   public void onCreate(){
       super.onCreate();


       Foo foo = new Foo(this); //this is a reference to the activity AND is also the context;
   }
}