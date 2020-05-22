public class MainActivity extends AppCompatActivity {
    ArrayList<Integer> creditIds;
    ArrayList<Integer> gradeIds;
    ArrayList<String> credits;
    ArrayList<String> grades;
    ArrayList<Integer> gradePoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        credits=new ArrayList<>();
        grades=new ArrayList<>();
        gradePoints=new ArrayList<>();
        fill2015();
        creditIds=new ArrayList<>();
        gradeIds=new ArrayList<>();
        final LinearLayout myData=(LinearLayout)findViewById(R.id.myData);
        addforanothersubject(myData);
        Button b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            addforanothersubject(myData);
            }
        });
    }
    void addforanothersubject(LinearLayout myData)
    {
        Context c=MainActivity.this;
        LinearLayout.LayoutParams lp = new 
LinearLayout.LayoutParams(LinearLayout
                .LayoutParams.MATCH_PARENT, 
LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout l=new LinearLayout(c);
        l.setOrientation(LinearLayout.HORIZONTAL);
        l.setLayoutParams(lp);
        l.setGravity(Gravity.CENTER_HORIZONTAL);
        Spinner creditspinner=new Spinner(c);
        Spinner gradespinner=new Spinner(c);
        ArrayAdapter<String> creditSpinnerArrayAdapter = new ArrayAdapter<>
(c,
                android.R.layout.simple_spinner_item, credits);
        creditspinner.setAdapter(creditSpinnerArrayAdapter);
        ArrayAdapter<String> gradeSpinnerArrayAdapter = new ArrayAdapter<>
(c,
                android.R.layout.simple_spinner_item, grades);
        gradespinner.setAdapter(gradeSpinnerArrayAdapter);
        l.addView(creditspinner);
        l.addView(gradespinner);
        myData.addView(l);
    }
    void fill2015()
    {
        grades.add("O");        grades.add("A+");
        grades.add("A");        grades.add("B+");
        grades.add("B");        grades.add("C");
        grades.add("P");        grades.add("F");
        grades.add("Ab");        grades.add("I");
        gradePoints.add(10);        gradePoints.add(9);
        gradePoints.add(8);        gradePoints.add(7);
        gradePoints.add(6);        gradePoints.add(5);
        gradePoints.add(4);        gradePoints.add(0);
        gradePoints.add(0);        gradePoints.add(0);
        for(int i=1;i<=10;i++)
            credits.add(""+i);
    }
}