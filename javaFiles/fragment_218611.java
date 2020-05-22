public class InterventoActivity extends AppCompatActivity implements IInterventoActivity {

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private Bundle dataA = null;
    @Override
    public void setDataAAndFinish(whateverType data) {
        dataA = data;
        Intent intent = new Intent();
        intent.putExtra("data", data)
        setResult(RESULT_OK, intent);        
        finish();
    }
}