oneBtn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // no need to use onBtn here cuz the param v is the clicked View
        Button clickedButton = (Button) v;
        clickedButton.setText("1");
        numTxt.setText(numTxt.getText().toString() + " " + clickedButton.getText());
        //numTxt.append("1");
    }
});