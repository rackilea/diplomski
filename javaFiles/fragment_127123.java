/**
 * Interface definition for a callback to be invoked when the selected date is changed.
 */
public interface OnDateChangedListener {

    /**
     * Called when the selected date is changed.
     * @param oldDay The day value of old date.
     * @param oldMonth The month value of old date.
     * @param oldYear The year value of old date.
     * @param newDay The day value of new date.
     * @param newMonth The month value of new date.
     * @param newYear The year value of new date.
     */
    public void onDateChanged(int oldDay, int oldMonth, int oldYear, int newDay, int newMonth, int newYear);
}