protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);

String type = getIntent().getString("tipo");
int accao = getIntent().getInt("accao");

if (type != null && type.equals("medicamentos")) {
    Button voltar = (Button) findViewById(R.id.button1);
    voltar.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Intent medIntent = new Intent(view.getContext(), Listar.class);
            startActivityForResult(medIntent, 0);
        }
    });
    if (accao==1)
        setContentView(R.layout.adicionar_medicamentos);

    if (accao==2)
        setContentView(R.layout.editar_medicamentos);
}