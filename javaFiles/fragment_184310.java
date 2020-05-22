class MyDialogFragment extends DialogFragment
{
    public static MyDialogFragment newInstance( int datY, int datM, int datD, DatePickerDialog.OnDateSetListener listener )
    {
        Bundle bundle = new Bundle( 3 );
        bundle.putInt( "y", datY );
        bundle.putInt( "m", datM );
        bundle.putInt( "d", datD );

        MyDialogFragment fragment = new MyDialogFragment();
        fragment.setArguments( bundle );
        fragment.listener = listener;
        return fragment;
    }

    public DatePickerDialog.OnDateSetListener listener = null;

    // Not entirely sure if this is still necessary    
    @Override
    public void onDestroyView()
    {
        if(getDialog() != null && getRetainInstance())
        {
            getDialog().setDismissMessage(null);
            super.onDestroyView();
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle state)
    {
        return new DatePickerDialog(
            getActivity(),
            listener,
            getArguments().getInt( "y" ),
            getArguments().getInt( "m" ),
            getArguments().getInt( "d" )
        );
    }
}