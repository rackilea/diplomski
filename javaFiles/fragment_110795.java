public class MainActivity extends Activity {
    private RadioGroup rgsexo;
    EditText editPeso;
    EditText editAltura;
    TextView imcView;
    SeekBar alterarAltura;
    SeekBar alterarPeso;
    alterarAltura.setOnSeekBarChangeListener(alteraralturaListener);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_layout);

        editPeso = (EditText)findViewById(R.id.editPeso);
        editAltura = (EditText)findViewById(R.id.editAltura);
        imcView = (TextView)findViewById(R.id.imcView);
        alterarAltura = (SeekBar)findViewById(R.id.alterarAltura);
        alterarPeso = (SeekBar)findViewById(R.id.alterarPeso);
        alterarAltura.setOnSeekBarChangeListener(alteraralturaListener);

    }

    private OnSeekBarChangeListener alteraralturaListener = new OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
        boolean fromUser) {
            // TODO Auto-generated method stub
            // Calcula o novo valor do TIP
            editAltura=(alterarAltura.getProgress()) * .01;
            // mostra na caixa o valor novo
            alterarAltura.setText(String.format("%.02f", editAltura).replace(',', '.'));
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }
    };
}