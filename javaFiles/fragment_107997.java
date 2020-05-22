import java.util.Calendar;

    import android.app.Activity;
    import android.app.AlertDialog;
    import android.app.DatePickerDialog;
    import android.app.DatePickerDialog.OnDateSetListener;
    import android.app.Dialog;
    import android.app.TimePickerDialog;
    import android.app.TimePickerDialog.OnTimeSetListener;
    import android.content.DialogInterface;
    import android.content.Intent;
    import android.content.pm.ActivityInfo;
    import android.os.Bundle;
    import android.telephony.SmsManager;
    import android.view.View;
    import android.view.View.OnClickListener;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;
    import android.widget.TimePicker;

    public class SettingsScreen extends Activity {


private TextView tvDisplayTime;
private TimePicker timePicker1;
private Button btnChangeTime;

private int hour;
private int minute;

static final int TIME_DIALOG_ID = 999;

Button change_date_but;
TextView display_txt;
public static final int Date_dialog_id = 1;

// date
private int mYear;
private int mMonth;
private int mDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.screen_settings);
this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

final EditText inputTxt1 = (EditText) findViewById(R.id.conPhoneNum);    
Button saveBtn1 = (Button) findViewById(R.id.btnSave1);

setCurrentTimeOnView();
//addListenerOnButton();
change_date_but = (Button) findViewById(R.id.change_button_id);
display_txt = (TextView) findViewById(R.id.display_id);
change_date_but = (Button) findViewById(R.id.change_button_id);
Button retTimeBtn = (Button) findViewById(R.id.btnRetTime);
Button homeButton = (Button) findViewById(R.id.btnHome);
btnChangeTime = (Button) findViewById(R.id.btnChangeTime);



change_date_but.setOnClickListener(new OnClickListener() {

    @Override
    public void onClick(View v) {
    OnDateSetListener mDateSetListener = null;
    DatePickerDialog DPD = new DatePickerDialog(
    SettingsScreen.this, mDateSetListener, mYear, mMonth, mDay);
    DPD.show();
    }

    final Calendar c = Calendar.getInstance();{
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);}
        /*void updateDisplay1() {
        }*/
        });


        saveBtn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              String phoneNum1 = inputTxt1.getText().toString();
              savenum1(phoneNum1);

      //Intent passIntent = new Intent();
      //passIntent.putExtra("phoneNum", phoneNum1);

        }
        });



homeButton.setOnClickListener(new View.OnClickListener(){
    public void onClick(View view) {
        startHome();
        }
        });



retTimeBtn.setOnClickListener(new OnClickListener()
        {
  @Override
  public void onClick(View view) {
    //returnTime();

          } 
       });






    btnChangeTime.setOnClickListener(new OnClickListener() {

        @SuppressWarnings("deprecation")
        @Override
        public void onClick(View v) {

            showDialog(TIME_DIALOG_ID);
        }
    }); 


    }















    //display current time
public void setCurrentTimeOnView() {

    tvDisplayTime = (TextView) findViewById(R.id.tvTime);
    timePicker1 = (TimePicker) findViewById(R.id.timePicker1);

    final Calendar c = Calendar.getInstance();
    hour = c.get(Calendar.HOUR_OF_DAY);
    minute = c.get(Calendar.MINUTE);

    // set current time into textview
    tvDisplayTime.setText(
           new StringBuilder().append(pad(hour))
                              .append(":").append(pad(minute)));

    // set current time into timepicker
    timePicker1.setCurrentHour(hour);
    timePicker1.setCurrentMinute(minute);

}



private Object pad(int minute2) {
    // TODO Auto-generated method stub
    return null;
}


@Override
protected Dialog onCreateDialog(int id) {
    switch (id) {
    case TIME_DIALOG_ID:

        OnTimeSetListener timePickerListener = null;
        // set time picker as current time
        return new TimePickerDialog(this, 
                                 timePickerListener, hour, minute,false);

    }
    return null;
}



    /*

@Override
@Deprecated
protected void onPrepareDialog(int id, Dialog dialog) {
// TODO Auto-generated method stub
super.onPrepareDialog(id, dialog);
((DatePickerDialog) dialog).updateDate(mYear, mMonth, mDay);
}

private DatePickerDialog.OnDateSetListener mDateSetListener = new
        DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
         int dayOfMonth) {
        mYear = year;
        mMonth = monthOfYear;
        mDay = dayOfMonth;
        updateDisplay();
         }
        };



        private void updateDisplay() {
            // TODO Auto-generated method stub
            display_txt.setText(new StringBuilder()
            // Month is 0 based so add 1
            .append(mMonth + 1).append("-").append(mDay).append("-")
            .append(mYear));

            }
        */





public void startHome() {
   Intent launchHome = new Intent();
   launchHome.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
   launchHome.setClassName(this,"com.becatech.gsmzonecontroller.MainActivity");
   startActivity(launchHome);     
}






public void savenum1(String phoneNum1) {

AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);

dlgAlert.setMessage("Saved " + phoneNum1);
dlgAlert.setPositiveButton("OK", null);
dlgAlert.setCancelable(true);

dlgAlert.setPositiveButton("Ok",
    new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
          //dismiss the dialog  
        }
    });    
dlgAlert.create().show();
}





public void returnTime(){

SmsManager smsManager = SmsManager.getDefault();
smsManager.sendTextMessage("", null, "#TU?", null, null);

}
    }