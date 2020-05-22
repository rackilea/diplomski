ProgressDialog prepareDialog() {
    ProgressDialog pr = new ProgressDialog(this);
    pr.setTitle(R.string.Download);
    pr.setCanceledOnTouchOutside(false);
    pr.setCancelable(false);
    pr.setMessage(getString(R.string.Wait_));
    return pr;
}

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    prdialog = prepareDialog();
    prdialog.show();
    //do some operations
    prdialog.dismiss();
}