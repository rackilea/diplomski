EditText[] editTexts;
@Override
protected void onCreate(Bundle savedInstanceState) {
    // After setting contentView and other initialisations
    editTexts = new EditText[] {monthly_rent_et, water_et, ....};
    for (int i=0 ; i<editTexts.length ; i++) {
        editTexts[i].setOnFocusChangeListener(mFocusChangeListener);
    }
}

private View.OnFocusChangeListener mFocusChangeListener = new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        int total = 0;
        for (int i=0 ; i<editTexts.length ; i++) {
            try {
                total += Integer.valueOf(editTexts[i].getText().toString());
            } catch(Exception e) {}
        }
        total_et.setText(total + "");
    }
};