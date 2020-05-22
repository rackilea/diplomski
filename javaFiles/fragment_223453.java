private void dialogCustom(final TextView v) {
    AlertDialog.Builder editTxtDialog = new AlertDialog.Builder(this);
    LinearLayout layout = new LinearLayout(this);
    layout.setOrientation(LinearLayout.VERTICAL);
    EditText input1 = new EditText(this);
    editTxtDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            v.setText("Some text");
        }
    });
    input1.setHint("Change the task..");
    layout.addView(input1);
    editTxtDialog.setView(layout);
    editTxtDialog.show();
}