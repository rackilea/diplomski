protected void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   List<double[]> lokal = readCsv(getApplicationContext());

   ArrayList<String> array = new ArrayList<String>();  // initialize ArrayList here, may want to declare as class variable

   for (double[]sor : lokal) {
    for(int i=0; i<sor.length; i++) {
       mean(sor);
       String row = Double.toString(mean(sor));
       array.add(row);   // add your String to it here