//MainActivity.java

        import android.app.TimePickerDialog;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.TimePicker;

        public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);

                findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerFragment dialogFragment = new TimePickerFragment();
                        dialogFragment.show(getSupportFragmentManager(), "timePicker");
                    }
                });
            }

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.d("Time", hourOfDay + ":" + minute);
            }
        }

    //TimePickerFragment.java 


    import android.app.Dialog;
    import android.app.TimePickerDialog;
    import android.os.Bundle;
    import android.support.annotation.NonNull;
    import android.support.v4.app.DialogFragment;
    import android.text.format.DateFormat;

    import java.util.Calendar;

    /**
     * Created by Azeez.Taiwo on 7/21/2017.
     */

    public class TimePickerFragment extends DialogFragment {

        @NonNull
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            return new TimePickerDialog(getActivity(),
                    (TimePickerDialog.OnTimeSetListener)getActivity(), hour, minute,
                    DateFormat.is24HourFormat(getActivity()));

        }
    }

//activity_main.xml

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_below="@+id/gallery">


    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="open TIME picker"
        />

</LinearLayout>