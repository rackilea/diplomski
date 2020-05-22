private void showPasswordDialog(Context context) {
    final EditText input = new EditText(context);
    input.setSingleLine();
    AlertDialog.Builder alert = new AlertDialog.Builder(context);
    alert.setTitle("PASSWORD");
    alert.setView(input);
    alert.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            networkPass = input.getText().toString();
            if(ConnectActivity.this.passwordListener != null)
                ConnectActivity.this.passwordListener.onPasswordTyped();
        }
    });
    alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
        }
    });
    alert.show();

}