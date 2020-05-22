private TimePick tp;
static EditText start;
static EditText start1;
static EditText start2;
static EditText end;
static EditText end1;
static EditText end2;
static EditText editTextH1;
static String b,b1,b2;
static String c,c1,c2;

public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    tp = new TimePick();
    start = (EditText) findViewById(R.id.editText);
    end = (EditText) findViewById(R.id.editText2);
    start1 = (EditText) findViewById(R.id.editText3);
    end1 = (EditText) findViewById(R.id.editText4);
    start2 = (EditText) findViewById(R.id.editText5);
    end2 = (EditText) findViewById(R.id.editText6);
    editTextH1=(EditText)findViewById(R.id.editText7); // display total hours based on user input
    start.setOnClickListener(this);
    end.setOnClickListener(this);
    start1.setOnClickListener(this);
    end1.setOnClickListener(this);
    start2.setOnClickListener(this);
    end2.setOnClickListener(this);
}

public void onClick(View v) {
    int id = v.getId();
    if (id == R.id.editText)
    {
        tp.setFlag(TimePick.FLAG_START_DATE);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        tp.show(ft, "TimePicker");
    }
    if(id==R.id.editText2)
    {
        tp.setFlag(TimePick.FLAG_END_DATE);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        tp.show(ft, "TimePicker");
    }
    if(id==R.id.editText3)
    {
        tp.setFlag(TimePick.FLAG_START_DATE1);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        tp.show(ft, "TimePicker");
    }
    if(id==R.id.editText4)
    {
        tp.setFlag(TimePick.FLAG_END_DATE1);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        tp.show(ft, "TimePicker");
    }
    if(id==R.id.editText5)
    {
        tp.setFlag(TimePick.FLAG_START_DATE2);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        tp.show(ft, "TimePicker");
    }
    if(id==R.id.editText6)
    {
        tp.setFlag(TimePick.FLAG_END_DATE2);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        tp.show(ft, "TimePicker");
    }
}

public static class TimePick extends android.app.DialogFragment implements TimePickerDialog.OnTimeSetListener
{
    public static final int FLAG_START_DATE = 00;
    public static final int FLAG_END_DATE = 01;
    public static final int FLAG_START_DATE1 = 10;
    public static final int FLAG_END_DATE1 = 11;
    public static final int FLAG_START_DATE2 = 20;
    public static final int FLAG_END_DATE2 = 21;
    private int flag = 0;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        final Calendar c= Calendar.getInstance();
        int hour=c.get(Calendar.HOUR_OF_DAY);
        int minute=c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),this,hour,minute, DateFormat.is24HourFormat(getActivity()));
    }
    public void setFlag(int i) {
        flag = i;
    }
    @Override
    public void onTimeSet(TimePicker view,int hourofDay, int minute)
    {
        if (flag == FLAG_START_DATE)
        {
            start.setText(Integer.toString(hourofDay) + ":" + Integer.toString(minute));
            b=start.getText().toString();
        }
        if (flag == FLAG_END_DATE)
        {
            end.setText(Integer.toString(hourofDay) + ":" + Integer.toString(minute));
            c=end.getText().toString();
        }
        if (flag == FLAG_START_DATE1)
        {
            start1.setText(Integer.toString(hourofDay) + ":" + Integer.toString(minute));
            b1=start1.getText().toString();
        }
        if (flag == FLAG_END_DATE1)
        {
            end1.setText(Integer.toString(hourofDay) + ":" + Integer.toString(minute));
            c1=end1.getText().toString();
        }
        if (flag == FLAG_START_DATE2)
        {
            start2.setText(Integer.toString(hourofDay) + ":" + Integer.toString(minute));
            b2=start2.getText().toString();
        }
        if (flag == FLAG_END_DATE2)
        {
            end2.setText(Integer.toString(hourofDay) + ":" + Integer.toString(minute));
            c2=end2.getText().toString();
        }
      SimpleDateFormat format= new SimpleDateFormat("HH:mm");
        try {
            Date dateb = format.parse(b);
            Date datec = format.parse(c);
            Date dateb1 = format.parse(b1);
            Date datec1 = format.parse(c1);
            Date dateb2 = format.parse(b2);
            Date datec2 = format.parse(c2);
          /*long difference = date2.getTime() - date1.getTime();
            int minutes = (int) ((difference/ (1000*60)) % 60);
            int hours   = (int) ((difference/ (1000*60*60)) % 24)-1;
            editTextH1.setText((hours+":"+minutes));*/
          long dateb_sum = dateb.getTime() + dateb1.getTime() + dateb2.getTime();
            long datec_sum = datec.getTime() + datec1.getTime() + datec2.getTime();

            long difference = datec_sum - dateb_sum;
            int minutes = (int) ((difference/ (1000*60)) % 60);
            int hours   = (int) ((difference/ (1000*60*60)) % 24)-1;
            editTextH1.setText((hours+":"+minutes));

        }catch (Exception e)
        {
        }
    }
}