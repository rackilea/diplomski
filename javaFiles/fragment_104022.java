btnAdd.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        cbHomework = new CheckBox(MainActivity.this);
        cbHomework.setText(edtHomework.getText().toString());
        llHomework.addView(cbHomework);

        cbHomework.setOnCheckedChangedListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if(isChecked)
                        llHomework.removeView(compoundButton);
                }
            });
    }
});