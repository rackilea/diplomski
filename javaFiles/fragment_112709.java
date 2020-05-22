void prepareDialog() {
    if (prDialog == null)
        prDialog = new ProgressDialog(this);

    prDialog.setTitle(R.string.Download);
    prDialog.setCanceledOnTouchOutside(false);
    prDialog.setCancelable(false);
    prDialog.setMessage(getString(R.string.Wait_));
}

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    prepareDialog();

    prdialog.show();
    //do some operations
    prdialog.dismiss();
}