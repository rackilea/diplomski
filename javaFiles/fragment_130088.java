public class MainActivity implements DatePickerFragment.OnDatePickedListner {
    @Override
    public void onDatePicked(Date date) {
        Absences fragment = (Absences) getSupportFragmentManager().findFragmentById(R.id.Absences);
        fragment.updateAbsences();
    }
}