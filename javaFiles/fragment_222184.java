View.OnClickListener rbClick = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        RadioButton checked_rb = (RadioButton) v;
        if(lastCheckedRB != null){
            lastCheckedRB.setChecked(false);
        }
        .....
        .....
        //Create Statis Mathod in ActivityCheckout and Access Hear
         ActivityCheckout.updateTextView(String DataUWantToAdd);
    }
};