public class calender_fragment extends Fragment { 
View myView;
EditText date;
DatePickerDialog datePickerDialog;

@Nullable 
@Override 
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    myView = inflater.inflate(R.layout.calender_layout, container, false);


    // initiate the date picker and a button 
    date = (EditText) myView.findViewById(R.id.date); /** <-- use View.findViewById() in Fragment */

    // perform click event on edit text 
    date.setOnClickListener(new View.OnClickListener() {
        @Override 
        public void onClick(View v) {
            // calender class's instance and get current date , month and year from calender 
            final Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR); // current year
            int mMonth = c.get(Calendar.MONTH); // current month
            int mDay = c.get(Calendar.DAY_OF_MONTH); // current day

            // date picker dialog 
            datePickerDialog = new DatePickerDialog(getActivity(),  /* <-- use getActivity() */
                    new DatePickerDialog.OnDateSetListener() {

                        @Override 
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // set day of month , month and year value in the edit text 
                            date.setText(dayOfMonth + "/"
                                    + (monthOfYear + 1) + "/" + year);

                        } 
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        } 
    }); 

    return myView;  /* <--- move the "return" here */
}