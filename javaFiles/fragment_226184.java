public class MainActivity implements OnTaskCompleted {
    //...

   @Override
   protected void onCreate(Bundle savedInstanceState) {
   ...
        Connection con=new Connection(MainActivity.this);
        con.execute(url);
   ...
   }

   @Override
   public onTaskCompleted(String value) {
       // you will receive the data here.
   }
}