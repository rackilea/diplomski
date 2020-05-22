View.OnClickListener button2Listener = new View.OnClickListener() {
    public void onClick(View v) {
        // I want to show a spinner if they click the second radio button
        if (v.getId() == R.id.radioButton1) mSpinner.setVisibility(View.INVISIBLE);
        if (v.getId() == R.id.radioButton2) mSpinner.setVisibility(View.VISIBLE);

    }
};