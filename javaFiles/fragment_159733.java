public class MainActivity extends AppCompatActivity {

private ArrayList<ModelloDati> dati = new ArrayList<>();
private LinearLayoutManager linearLayoutManager;
private static final String VIDEO_DIRECTORY = "/Chat";
private myAdapter adapter;
private RecyclerView recyclerView;
private VideoView videoView;
public  Uri passUri;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    // Variables-----------------------------------------

     recyclerView = findViewById(R.id.recyclerView);
    Button video = findViewById(R.id.video);
    Button camera = findViewById(R.id.camera);
    Button send = findViewById(R.id.send);
    final EditText editText = findViewById(R.id.editText);


    // Layout Manager------------------------------------------------

    linearLayoutManager = new LinearLayoutManager(MainActivity.this);
    linearLayoutManager.setStackFromEnd(true);
    RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
    recyclerView.setLayoutManager(linearLayoutManager);
    recyclerView.setItemAnimator(itemAnimator);


    // Adapter-----------------------------------------

        //adapter.notifyDataSetChanged();
        adapter =  new myAdapter(dati, this);
        recyclerView.setAdapter(adapter);



    // Click Listener Video button----------------------------------------------
    video.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            startActivityForResult(intent,0);
        }
    });

    // Click Listener Camera button----------------------------------------------
    camera.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,1);
        }
    });

    // Click Listener Send button------------------------------------------------
    send.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String string = editText.getText().toString();
            dati.add(new ModelloDati(0,string));
            adapter.notifyItemInserted(dati.size());
            editText.getText().clear();
            recyclerView.smoothScrollToPosition(dati.size());
            closeKeyboard();
        }
    });


}

private void closeKeyboard() {
    View view = getCurrentFocus();
    if(view != null){
        InputMethodManager imm = 
(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}


@Override
protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)  
{
    super.onActivityResult(requestCode, resultCode, data);
    switch (requestCode){
        case 0:
            try {
                Uri contentURI = data.getData();
                passUri = contentURI;
                String recordedVideoPath = getPath(contentURI);
                saveVideoToInternalStorage(recordedVideoPath);
                dati.add(new ModelloDati(2, contentURI));
                adapter.notifyItemInserted(dati.size());
                recyclerView.smoothScrollToPosition(dati.size());

            }catch (Throwable o){Log.i("CAM","User aborted action");}
        case 1:
            try {
                Bitmap bitmap = (Bitmap)data.getExtras().get("data");
                dati.add(new ModelloDati(1,bitmap));
                adapter.notifyItemInserted(dati.size());
                recyclerView.smoothScrollToPosition(dati.size());


            }catch(Throwable o){
                Log.i("CAM","User aborted action");
            }

    }


}



private void saveVideoToInternalStorage (String filePath) {

    File newfile;

    try {

        File currentFile = new File(filePath);
        File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() + 
VIDEO_DIRECTORY);
        newfile = new File(wallpaperDirectory, Calendar.getInstance().getTimeInMillis()  
 + ".mp4");

        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs();
        }

        if(currentFile.exists()){

            InputStream in = new FileInputStream(currentFile);
            OutputStream out = new FileOutputStream(newfile);

            // Copy the bits from instream to outstream
            byte[] buf = new byte[1024];
            int len;

            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
            Log.v("vii", "Video file saved successfully.");
        }else{
            Log.v("vii", "Video saving failed. Source file missing.");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

}



public String getPath(Uri uri) {
    String[] projection = { MediaStore.Video.Media.DATA };
    Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
    if (cursor != null) {
        // HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
        // THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    } else
        return null;
}


}