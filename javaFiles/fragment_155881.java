public class MainActivity extends AppCompatActivity {

    Drawable d;                        // drawable for the image
    String imagepath = "image001.JPG"; // initial image
    ImgDBHelper imgdbhlpr;             // DB Helper
    ListView imagelist;                // ListView
    SimpleCursorAdapter sca;           // ListView's Cursor adapter
    Cursor images;                     // Cursor for the ListView
    ImageView iv;                      // The ImageView to display the image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imagelist = (ListView) findViewById(R.id.imagelist);
        iv = (ImageView) findViewById(R.id.myimage);

        imgdbhlpr = new ImgDBHelper(this);

        // Load the table if there are no images
        if (!imgdbhlpr.areImagesLoaded()) {
            for (int i=1;i < 11;i++) {

                String path = "image" +
                        String.format("%03d",i) +
                                ".JPG"
                        ;
                imgdbhlpr.addImageRow(path,"Image " +
                String.format("%03d",i));
            }
        }

        // get a cursor with all of the rows
        images = imgdbhlpr.getAllImages();

        // prepare the listview's adapter
        sca = new SimpleCursorAdapter(this,
                android.R.layout.simple_list_item_1,
                images,
                new String[]{ImgDBHelper.DSCR_COL},
                new int[]{android.R.id.text1},
                0
        );

        // set the Listview's onItemClick listener so that clicking an
        // item displays the respective image
        imagelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                iv.setImageDrawable(d = getImageFromAssets(
                        imgdbhlpr.getImagePathFromID(l)
                ));
            }
        });
        imagelist.setAdapter(sca);

        // set the initial image (image001.JPG)
        d = getImageFromAssets(imagepath);
        iv.setImageDrawable(d);
    }


    // routine to create a drawable according to the supplied path
    private  Drawable getImageFromAssets(String imagepath) {
        Drawable drawable = null;
        AssetManager am = this.getAssets();
        InputStream is = null;
        try {
            is = am.open(imagepath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            drawable = Drawable.createFromStream(is,null);
        } finally {
            try {
                is.close();
                is = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return drawable;
    }
}