EditText nombre;
EditText direccion;
Button insertar;
Button ver;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    nombre = (EditText) findViewById(R.id.editText1);
    direccion = (EditText) findViewById(R.id.editText2);
    insertar = (Button) findViewById(R.id.Insertar);
    ver = (Button) findViewById(R.id.Ver);

    insertar.setOnClickListener(this);
    ver.setOnClickListener(this);

}