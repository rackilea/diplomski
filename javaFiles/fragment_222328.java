public class FirstActivity extends Activity{

   //setup button 1 and two first, then set their onClickLiseners like so

   View.OnClickListener clickListener = new View.OnClickListener(){
      public void onClick(View view){
        Intent newActivity = new Intent(FirstActivity.this, SecondActivity.class);
        if(view == button1){
          //add extra to intent indicating button1 was clicked
        }
        else{
          //add extra to intent indicating button2 was clicked
        }
        startActivity(newActivity);
      }
    };


  // other stuff in your activity
}


public class SecondActivity extends Activity{

  protected void onCreate(Bundle icicle){
     Intent startedBy = getIntent();
     if(started by has the extra indicating button 1 was clicked){
       //do button1 stuff
     }
     else{
       //do button2 stuff 
     }
   }
}


}