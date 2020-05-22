class MyActivity extends Activity{

 int mySounds[] = {R.raw.s1, R.raw.s2}; //etc. could also be a 2d array, one for each page of sounds.

 protected void onCreate(Bundle b)
 {
   setContentView(R.layout.myactivity);

   ListView lv = (ListView) findViewById(R.id.myactivity_listView);

   lv.setAdapter(new SoundAdapter(this));

 }

class SoundAdapter extends BaseAdapter{
  Context cont;
  SoundAdapter(Context c){
   this.cont = c;
  }

  getView(int id, View convertView){
   if(convertView == null){
     ...
     //inflate view to be a row/gridcell
   }

   convertView.setOnClickListener(new SoundClickListener(mySounds[id]));
  }



}

 class SoundClickListener extends View.OnClickListener{

   int resId;

   public SoundClickListener(int resId)
   {
     this.resId = resId;
   }

   protected void onClick(View v){
     playSoundWithId(resId);
   }

 }

}