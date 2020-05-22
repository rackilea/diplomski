public class MainActivity extends Activity {

RelativeLayout rl; 
final int PIC_CROP = 1;
ImageView iv;
 File file;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    rl = (RelativeLayout) findViewById(R.id.rl);
     Button b= (Button) findViewById(R.id.button1); 
     iv= (ImageView) findViewById(R.id.imageView1);
     b.setOnClickListener(new OnClickListener()
     {

      @Override
      public void onClick(View v) {
          save();
     }
     });
}

   public void save()
   {
       AlertDialog.Builder editalert = new AlertDialog.Builder(MainActivity.this);
       editalert.setTitle("Please Enter the name with which you want to Save");
       final EditText input = new EditText(MainActivity.this);
       LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
               LinearLayout.LayoutParams.FILL_PARENT,
               LinearLayout.LayoutParams.FILL_PARENT);
       input.setLayoutParams(lp);
       editalert.setView(input);
       editalert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
           public void onClick(DialogInterface dialog, int whichButton) {
               rl.setDrawingCacheEnabled(true);
               String name= input.getText().toString();
               Bitmap bitmap =rl.getDrawingCache();
               String root = Environment.getExternalStorageDirectory().toString();
               File myDir = new File(root + "/MyDraw");    
               myDir.mkdirs();
               file = new File (myDir, name+".png");
               if (file.exists ()) file.delete ();         
               try 
               {
                   if(!file.exists())
               {
                   file.createNewFile();
               }
                   FileOutputStream ostream = new FileOutputStream(file);
                   bitmap.compress(CompressFormat.PNG, 10, ostream);
                   ostream.close();
                   Uri uri = Uri.fromFile(new File(file.getAbsolutePath()));
                   performCrop(uri);                          
               } 
               catch (Exception e) 
               {
                   e.printStackTrace();
               }
           }
       });
       editalert.show(); 
   }


   private void performCrop(Uri picUri) {
    try {

   Intent cropIntent = new Intent("com.android.camera.action.CROP");
   // indicate image type and Uri
   cropIntent.setDataAndType(picUri, "image/*");
   // set crop properties
   cropIntent.putExtra("crop", "true");
   // indicate aspect of desired crop
   cropIntent.putExtra("aspectX", 1);
   cropIntent.putExtra("aspectY", 1);
   // indicate output X and Y
   cropIntent.putExtra("outputX", 128);
   cropIntent.putExtra("outputY", 128);
   // retrieve data on return
   cropIntent.putExtra("return-data", true);
   // start the activity - we handle returning in onActivityResult
   startActivityForResult(cropIntent, PIC_CROP);
 }
 // respond to users whose devices do not support the crop action
 catch (ActivityNotFoundException anfe) {
  // display an error message
  String errorMessage = "Whoops - your device doesn't support the crop action!";
  Toast toast = Toast.makeText(MainActivity.this, errorMessage, Toast.LENGTH_SHORT);
  toast.show();
  }
 }




 @Override
 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
 super.onActivityResult(requestCode, resultCode, data);

 if (requestCode == PIC_CROP) {
  if (data != null) {
      // get the returned data
      Bundle extras = data.getExtras();
      // get the cropped bitmap
      Bitmap selectedBitmap = extras.getParcelable("data");
      FileOutputStream ostream;
    try {
        ostream = new FileOutputStream(file);
        selectedBitmap.compress(CompressFormat.PNG, 10, ostream);
         ostream.close(); 
    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

      iv.setImageBitmap(selectedBitmap);
  }
  }
  }