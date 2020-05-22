public void computeDonation(View v){
    String addedText = ((EditText)findViewById(R.id.AmountText)).getText().toString();
    if (TextUtils.isEmpty(textAdded)) {
        Toast.makeText(context, "Please enter a valid number", Toast.LENGTH_SHORT).show();
    } else {
        DonationModel donation = new DonationModel(addedText);
        String answer = donation.calcDonation();
        ((TextView)findViewById(R.id.totalText)).setText(answer);
    }
}