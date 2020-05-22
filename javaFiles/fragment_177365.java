btnIncrement.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {         
        if (i1.isChecked())
            counter++;

        if(i2.isChecked())
            counter2++;

        if (i3.isChecked())
            counter2++;
        tvCounter.setText(String.valueOf(counter));
        tvCounter2.setText(String.valueOf(counter2));
    }
}); }
}