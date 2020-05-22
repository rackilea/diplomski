public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    /**
     * The callback interface used to indicate the user is done filling in the date (they clicked on the 'Set' button).
     */
    public interface OnDateSetListener {

        /**
         * @param dialog The view associated with this listener.
         * @param year The year that was set.
         * @param monthOfYear The monthOfYear that was set.
         * @param dayOfMonth The dayOfMonth that was set.
         */
        void onDateSet(DatePicker dialog, int year, int monthOfYear, int dayOfMonth, int reqCode);
    }

    private OnDateSetListener mListener;
    private int reqCode;
    public void setOnDateSetListener(OnDateSetListener mListener, int reqCode){
        this.mListener  = mListener;
        this.reqCode = reqCode;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        int year;
        int month;
        int day;
        final Calendar c = Calendar.getInstance();
        Bundle bundle = this.getArguments();
        if(bundle!=null) {
            // Use the given date as the default date in the picker
            year = bundle.getInt("YEAR");
            month = bundle.getInt("MONTH");
            day = bundle.getInt("DAY");
        }else{
            // Use the current date as the default date in the picker
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH);
            day = c.get(Calendar.DAY_OF_MONTH);
        }

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        if(mListener!=null)
            mListener.onDateSet(view, year, monthOfYear, dayOfMonth, reqCode);
        this.dismiss();
    }
}