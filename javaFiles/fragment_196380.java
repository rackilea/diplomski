public class MainActivity extends AppCompatActivity implements  View.OnClickListener {
    EffetMatrix effetMatrix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        effetMatrix = (EffetMatrix) findViewById(R.id.arrPlan);        
        ...
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.b_b:
                effetMatrix.setCustomTextColor(Color.BLUE);
                break;
            case R.id.b_r:
                effetMatrix.setCustomTextColor(Color.RED);
                break;
            case R.id.b_ro:
                effetMatrix.setCustomTextColor(Color.MAGENTA);
                break;
        }
    }
}