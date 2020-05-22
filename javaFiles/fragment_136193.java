void onClick(View v)
{
    Dialog d = new Dialog(v.getContext());
                          ^^^^^^^^^^^^^^
    TextView testField = new TextView(v.context);
    testField.setText("Success!");
    d.setContentView(testField);
    d.show();
}