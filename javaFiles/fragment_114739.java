public class MainActivity implements TimePickerDialog.OnTimeSetListener {

    ...

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Toast.makeText(this, "chosen hour of day: " + hourOfDay, Toast.LENGTH_LONG).show();
    }
}