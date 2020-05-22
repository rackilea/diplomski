public class MainActivity extends Activity {

        private static final long duration = 50000;
        private static final long interval = 1500;

     // ID of Image View
public static int[] CellID=new int[]{
         R.id.mycell01,R.id.mycell02,R.id.mycell03,R.id.mycell04,
         R.id.mycell05,R.id.mycell06,R.id.mycell07,R.id.mycell08,R.id.mycell09};
     // Image View name
static ImageView img01,img02,img03,img04,img05,img06,img07,img08,img09;
    // Array of ImageView
public static ImageView[] ImageViewImg=new ImageView[]{
        img01,img02,img03,img04,img05,img06,img07,img08,img09};


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
    for (int i = 0; i < ImageViewImg.length; i++) {
            ImageViewImg[i]=(ImageView)findViewById(CellID[i]);


        }

        }