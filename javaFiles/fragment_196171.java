public class MyClass extends AppCompatActivity {

    Calendar cal;
    Button selectDate;
    DatePickerDialog datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trains_bw_stations);
        selectDate=findViewById(R.id.select_date);
        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cal = Calendar.getInstance();

                final DatePickerDialog.OnDateSetListener dateA = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                    int dayOfMonth) {
                // TODO Auto-generated method stub
                       cal.set(Calendar.YEAR, year);
                       cal.set(Calendar.MONTH, monthOfYear);
                       cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                }
            };

        new DatePickerDialog(MyClass.this, dateA, cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }
}