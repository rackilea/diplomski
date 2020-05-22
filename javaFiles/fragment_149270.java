import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

    private int year;
    private int month;
    private int day;
    static final int DATE_PICKER_ID = 1111;

    // for date picker
     EditText m3_DateDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

         setContentView(R.layout.activity_main);

        m3_DateDisplay = (EditText) findViewById(R.id.datepick);

        // Get current date by calender

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);




        // Show selected date
        StringBuilder dateValue1 = new StringBuilder().append(day).append("-")
                .append(month + 1).append("-").append(year).append(" ");

        // for Converting Correct Date format Save into Database
        SimpleDateFormat sdf123 = new SimpleDateFormat("dd-MM-yyyy");
        String abs1 = dateValue1.toString();
        Date testDate1 = null;
        try {
            testDate1 = sdf123.parse(abs1);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
        String DateFormat = formatter1.format(testDate1);

        m3_DateDisplay.setText(DateFormat);

        m3_DateDisplay.setFocusable(false);
        m3_DateDisplay.setInputType(InputType.TYPE_NULL);
        m3_DateDisplay.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View v) {
                showDialog(DATE_PICKER_ID);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
        case DATE_PICKER_ID:

            // open datepicker dialog.
            // set date picker for current date
            // add pickerListener listner to date picker
            // return new DatePickerDialog(this, pickerListener, year, month,
            // day);

            // ///Only Show till Date Not More than That.
            DatePickerDialog dialog = new DatePickerDialog(this,
                    pickerListener, year, month, day);
            dialog.getDatePicker().setMaxDate(new Date().getTime());
            return dialog;
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener pickerListener = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        @Override
        public void onDateSet(DatePicker view, int selectedYear,
                int selectedMonth, int selectedDay) {

            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // Show selected date
            StringBuilder dateValue = new StringBuilder().append(day)
                    .append("-").append(month + 1).append("-").append(year)
                    .append(" ");

            // for Converting Correct Date format Save into Database
            SimpleDateFormat sdf123 = new SimpleDateFormat("dd-MM-yyyy");
            String abs1 = dateValue.toString();
            Date testDate1 = null;
            try {
                testDate1 = sdf123.parse(abs1);
            } catch (ParseException e) {

                e.printStackTrace();
            }
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy");
            String DateFormat = formatter1.format(testDate1);

            m3_DateDisplay.setText(DateFormat);

        }
    };
}