public class MyClickListener implements OnClickListener 
{
    MainActivity act;
      public MyClickListener(MainActivity act) { 
         this.act=act;

      }
    @Override
    public void onClick(View v)
        {
            act.myFunction();

        } 
}