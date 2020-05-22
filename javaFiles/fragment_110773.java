public class PickerDialog extends DialogFragment {

    NumberPickerListener listener;

    ...

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View child = getActivity().getLayoutInflater().inflate(R.layout.dialog, null);
        listener = (MyActivity)getActivity();

        ...

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onValuesPicked(numberPicker.getValue(), numberPicker2.getValue(), numberPicker3.getValue());
                dismiss();
            }
        });

        ...
    }




}