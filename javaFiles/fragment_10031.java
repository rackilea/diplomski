public class MainActivity extends Activity {

    private String SettingSet;//Save what choice is set. Will be used in inici()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public void onClickHombre(View v){

        setContentView(R.layout.hombre_layout);
    }

    public void onClickMujer(View v){

        setContentView(R.layout.mujer_layout);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        View include = findViewById(R.id.includeinch);

        switch (item.getItemId()){
        case R.id.kgcm:
            if (item.isChecked());
            else{
                item.setChecked(true);
                SettingSet = "kgcm";
                if(include != null){//Do that only if in Main
                    findViewById(R.id.includeinch).setVisibility(View.INVISIBLE);
                    findViewById(R.id.includekg).setVisibility(View.VISIBLE);
                }
            }
            return true;
        case R.id.inch:
            if (item.isChecked());
            else{
                item.setChecked(true);
                SettingSet = "inch";
                if(include != null){//Do that only if in Main
                    findViewById(R.id.includekg).setVisibility(View.INVISIBLE);
                    findViewById(R.id.includeinch).setVisibility(View.VISIBLE);
                }   
            }
            return true;

        case R.id.salir:
            salir();
            return true;
        case R.id.inicio:
                //this function back on to main layout
            inici();
            return true;
        default:
        return super.onOptionsItemSelected(item);
        }
    }

    private void inici() {
        setContentView(R.layout.activity_main);
        if(SettingSet == "inch"){
            findViewById(R.id.includekg).setVisibility(View.INVISIBLE);
            findViewById(R.id.includeinch).setVisibility(View.VISIBLE);
        }
        else{
            findViewById(R.id.includekg).setVisibility(View.VISIBLE);
            findViewById(R.id.includeinch).setVisibility(View.INVISIBLE);
        }
    }

    private void salir() {
        // TODO Auto-generated method stub
    }
}