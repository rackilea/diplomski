@Override
 protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        final TextView texto = (TextView) findViewById(R.id.yourTextviewid);
        ponerColor= (Button) findViewById(R.id.ponerColor);
        borrar= (Button) findViewById(R.id.borrar);
        rojo= (CheckBox) findViewById(R.id.botonRojo);
        verde= (CheckBox) findViewById(R.id.botonVerde);
        azul= (CheckBox) findViewById(R.id.botonAzul);

        rojo.setOnCheckedChangeListener(
                new CheckBox.OnCheckedChangeListener(){
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked){
                            texto.setText("enga");
                        }
                    }
                }
        );

}