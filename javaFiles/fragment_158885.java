@Override
public void onResume() {
    super.onResume();  // Always call the superclass method first

    Bundle bundle = getIntent().getExtras();
    if(bundle != null)
        stringAddress = bundle.getString("address");
    edtxt_from.setText(stringAddress);
    edtxt_to.setText(stringAddress);
}