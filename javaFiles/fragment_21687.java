GraphView Grafico;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Grafico = new LineGraphView(this, "GraphTest"); 
}