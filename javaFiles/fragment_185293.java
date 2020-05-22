class MyDialogFragment extends DialogFragment {
    @Override
    public void onCreate( Bundle state ) {
        super.onCreate( state );

        setRetainInstance( true );
    }

    @Override
    public Dialog onCreateDialog( Bundle state ) {
        return new DatePickerDialog( ... );
    }
}