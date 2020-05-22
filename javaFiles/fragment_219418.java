submitBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String submitAmount = amountEnter.getText().toString();
        balance.setText(submitAmount);
PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).
edit().putString("balance", submitAmount).commit();

    }
});