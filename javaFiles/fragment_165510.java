public FragmentManager getSupportFragmentManager() {
    return null;
}
public void checkTime(View view) {
    DialogFragment newFragment = new TimePickerFragment();
    newFragment.show(getSupportFragmentManager(), "timePicker");

}