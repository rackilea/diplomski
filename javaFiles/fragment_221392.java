@Override
    public void onCreate(Bundle savedInstanceState)
    {
          setContentView(R.layout.your_layout);  // where your_layout is the name of the xml file with the layout you want to use minus the .xml extention
         //this layout must contain all of these views below that you are trying to initialize

          nameEt = (EditText) findViewById(R.id.nameEdit);
          capEt = (EditText) findViewById(R.id.capEdit);
          codeEt = (EditText) findViewById(R.id.codeEdit);
          timeEt = (TimePicker) findViewById(R.id.timeEdit);