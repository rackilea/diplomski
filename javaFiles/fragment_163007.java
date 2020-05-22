public class SpanishActivity extends ListActivity {

 static final String[] basicWords = new String[] {
   "Hello", "Goodbye", "Yes", "No", 
   "Why", "Where", "When", "What ", "Who", "How", "Absolutely", "I", "You",
   "He", "She", "That", "Black", "White", "Red","Orange", "Blue", "Green",
   "Yellow", "Purple", "Later" , "Now", "Today", "Tomorrow", "Left", "Right",
   "Hand", "Mouth", "Tongue", "Nose", "Ear", "Eyes", "Leg", "Dog", "Cat", 
   "Elephant", "Snake", "Camel", "Pen", "Pencil", "Book", "Paper", "Hot",
   "Cold", "Airplane", "Car", "Raining", "Sunny", "Cloudy", "Water", "Please",
   "Help", "Work", "English", "America", "England", "Funny", "Thanks", 
   "Good", "Bad", "Happy", "Sad", 
   };

 String[] spanishBasic = new String[]{
     "afsdfb", "qerg", "nt4th", "erhn", 

       "ehrethn", "rth", "Kub", "ygfd ", "cvb", "ytrfvh", "jhgv", "Mvbay",         "hgfv",

       "gv", "cvbnhg", "gfd", "hgf", "ytr", "hgf","wthw", "wetergh",     "wewrth",

       "weth", "erg", "wrgwr" , "dfghj", "xdhtcjfy", "cfj", "zsrxdtcf", "oiuy",

       "rxjtdcfky", "n", "dfgh", "sdfgh", "fgbh", "nkhn", "ayr", "ota",     "dfgh", 

       "Hafghi", "ghjnp", "Ogtyh", "dfg", "fghn", "fghjnm", "ghn", "hjk",

       "xdcfgh", "xcv", "hjdi", "fghish", "fghoop", "Bhjl", "bnani", "cvbn",

       "Mghj", "bhjam", "hjayzi", "ghjk", "vhj", "vghj", "cfgh", 

       "bhj", "bhjra", "ghjshi", "fghhum",   

 };

   /** Called when the activity is first created. */


   public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setListAdapter(new ArrayAdapter<String>(this,
               android.R.layout.simple_list_item_1, basicWords));
       getListView().setTextFilterEnabled(true);
   }

 protected void onListItemClick(ListView l, View v, int position, long id) {
  // TODO Auto-generated method stub
  super.onListItemClick(l, v, position, id);

  new AlertDialog.Builder(this)
   .setTitle("Spanish")
   .setMessage("" + spanishBasic[position])
   .setPositiveButton("Back to List",
     new DialogInterface.OnClickListener() {
      public void onClick(DialogInterface dialog, int which) {}}
     )
   .show();


 }


}