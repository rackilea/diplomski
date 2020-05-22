public class MainActivity extends AppCompatActivity {

    private  LineChart lc;
    private RelativeLayout view;

    private static final String TAG = "LCTP Main";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(Build.VERSION.SDK_INT > 22 && (checkSelfPermission(WRITE_EXTERNAL_STORAGE) != PERMISSION_GRANTED)) {
            requestPermissions(new String[]{READ_EXTERNAL_STORAGE, WRITE_EXTERNAL_STORAGE}, 13);
        }
        else {
            createLineChart(440.0);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 13){
            boolean ok = true;
            int length = permissions.length;
            for (int i = 0; i < length; i++) {
                String permission = permissions[i];
                if(grantResults[i] != PERMISSION_GRANTED){
                    Log.d(TAG, "onRequestPermissionsResult: missing permission " + permission);
                    ok = false;
                }
            }
            if(ok){
                createLineChart(220);
            }
        }
    }

    private void createLineChart(double frequency) {
        if(lc == null){
            view = findViewById(R.id.layParent);
            lc = findViewById(R.id.lncMain);
        }
        lc.setData(createLineData(frequency));

        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                Bitmap b = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Bitmap.Config.ARGB_8888);

                Canvas c = new Canvas(b);
                view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                view.draw(c);

                String filename = "graph.png";
                File sd = Environment.getExternalStorageDirectory();
                File dest = new File(sd, filename);

                try {
                    FileOutputStream out = new FileOutputStream(dest);
                    b.compress(Bitmap.CompressFormat.PNG, 90, out);
                    out.flush();
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Log.i(TAG, filename);
            }
        });
        lc.invalidate();
    }

    private LineData createLineData(double frequency) {
        List<Entry> yVals = new ArrayList<>();
        for(int i = 0; i < frequency; i = i + 10){
            yVals.add(new Entry(i, (float)Math.sin(i*i)));
        }
        ILineDataSet lineDataSet = new LineDataSet(yVals, "LabelString");
        LineData lineData = new LineData(lineDataSet);
        return lineData;
    }
}