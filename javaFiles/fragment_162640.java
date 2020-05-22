protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);

final EditText etTemp = (EditText) findViewById(R.id.txtTemperature);
final TextView tvOutput = (TextView) findViewById(R.id.lblOutput);
final RadioButton radFahToCelLogic = (RadioButton) findViewById(R.id.radFahToCel);
final RadioButton radCelToFahLogic = (RadioButton) findViewById(R.id.radCelToFah);

Button btnConvertLogic = (Button) findViewById(R.id.btnConvert);
btnConvertLogic.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        double dblFahrenheit = 0;
        double dblCelcius = (5.0/9) * (dblFahrenheit -32);
        double dblConvertedTemp = 0;
        double dblFahConversion;

        // format
        DecimalFormat dfTenth = new DecimalFormat("#.#");


        if (radFahToCelLogic.isChecked())
        {
            String strFah = etTemp.getText().toString();
            if (!strFah.isEmpty()){

              dblFahrenheit = Double.parseDouble(strFah);

              if (dblFahrenheit <= 212)
              {
                dblConvertedTemp = (5.0/9.0) * (dblFahrenheit - 32);
                tvOutput.setText (dfTenth.format(dblConvertedTemp));
              }
            }
        }

    }
});