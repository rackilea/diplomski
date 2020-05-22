public class YourActivity extends Activity implements OnMyFragDismissListener {

   // code...
    FragmentManager fragman = getFragmentManager();
    FragClass frag = new FragClass();
    frag.show(fm, "fragment_sub_connections");


  // code...

   @Override
   public void onMyFragDismissed(MyObject obj){
        // Fragment dismissed and object received!
   }

 }