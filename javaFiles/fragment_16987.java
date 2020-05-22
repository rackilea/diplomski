@Override
public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

    builder.setPositiveButton("OK", null);
    builder.setNegativeButton("Cancel", null);

    AlertDialog alertDialog = builder.create();

    // Here you can change the layout direction via setLayoutDirection()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
        alertDialog.getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
    }

    return alertDialog;
}