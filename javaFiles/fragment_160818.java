protected void startDialog() {
AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(this);
View view = (View) inflater.inflate(R.layout.addalbumsdialog, null);
myAlertDialog.setView(view);       
et1 = (EditText) view.findViewById(R.id.editText1);
b1 = (Button) view.findViewById(R.id.album1);
myAlertDialog.setTitle("Name?");
myAlertDialog.setView(inflater.inflate(R.layout.addalbumsdialog, null));
myAlertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

    @Override
    public void onClick(DialogInterface arg0, int arg1) {
        b1.setVisibility(View.VISIBLE);
        b1.setText(et1.getText().toString());

    }
});
myAlertDialog.show();
}