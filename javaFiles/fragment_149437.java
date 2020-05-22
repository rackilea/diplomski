public class TestActivity extends Activity implements ViewFactory,
        OnItemSelectedListener {

    private Gallery gallery;
    private ImageSwitcher iSwitcher;
    private RadioGroup rdgSelection;
    private Boolean flag = true;

    private Integer[] Array1 = { R.drawable.arrow, R.drawable.arrow1,
            R.drawable.arrow2, R.drawable.arrow3 };
    private Integer[] Array2 = { R.drawable.camera, R.drawable.camera1,
            R.drawable.camera2, R.drawable.camera3 };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gallery = (Gallery) findViewById(R.id.gallery);
        iSwitcher = (ImageSwitcher) findViewById(R.id.imgSwitcher);
        rdgSelection = (RadioGroup) findViewById(R.id.rdgSelection);

        iSwitcher.setFactory(this);
        rdgSelection.check(rdgSelection.getChildAt(
                rdgSelection.getChildCount() - 1).getId());

        if (rdgSelection.getCheckedRadioButtonId() == R.id.rdb1) {
            flag = true;
            gallery.setAdapter(new ImageAdapter(TestActivity.this));
        } else {
            flag = false;
            gallery.setAdapter(new ImageAdapter(TestActivity.this));
        }
        rdgSelection.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                gallery.setAdapter(new ImageAdapter(TestActivity.this));
                if (rdgSelection.getCheckedRadioButtonId() == R.id.rdb1)
                    flag = true;
                else
                    flag = false;
            }
        });
        gallery.setOnItemSelectedListener(this);

    }

    public class ImageAdapter extends BaseAdapter {
        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            if (flag)
                return Array1.length;
            else
                return Array2.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(mContext);
            if (flag)
                i.setImageResource(Array1[position]);
            else
                i.setImageResource(Array2[position]);
            i.setAdjustViewBounds(true);
            i.setLayoutParams(new Gallery.LayoutParams(
                    LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
            return i;
        }

        private Context mContext;

    }

    @Override
    public View makeView() {
        ImageView i = new ImageView(this);
        i.setBackgroundColor(0xFF000000);
        i.setScaleType(ImageView.ScaleType.FIT_CENTER);
        i.setLayoutParams(new ImageSwitcher.LayoutParams(
                LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
        return i;
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View v, int position,
            long id) {
        if (flag)
            iSwitcher.setImageResource(Array1[position]);
        else
            iSwitcher.setImageResource(Array2[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {

    }

}