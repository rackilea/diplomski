public class MyActivityDoctors extends Activity {

    ScrollView sv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sv =  (ScrollView) this.findViewById(R.id.ScrollViewDoctor);
    }

    public void addDoctor(Doctor doctor)
    {
        //Linear Layout inside your ScrollView
        LinearLayout ll = (LinearLayout) this.findViewById(R.id.linlay);

        //Create a new TextView with doctor data
        TextView tv = new TextView(this);
        tv.setText(doctor.getDocName());

        //Adding textView to LinearLayout
        ll.addView(tv);
    }

}