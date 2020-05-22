// Store this as a field for later reference
private SharedPreferences sf;
private final Calendar mCalendar = Calendar.getInstance();

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.widget);

    nameText = (TextView) findViewById(R.id.name);

    // Load any data you have 
    sf = getSharedPreferences("sf", Activity.MODE_PRIVATE);
    String str = sf.getString("name", ""); 
    long dday = sf.getLong("dday", -1); 
    // TODO: set mCalendar time using dday
    // if dday == -1, then nothing is saved 

    // load the date picker values 
    tYear = mCalendar.get(Calendar.YEAR);
    tMonth = mCalendar.get(Calendar.MONTH);
    tDay = mCalendar.get(Calendar.DAY_OF_MONTH);

    nameText.setText(str); 
    updateDisplay();