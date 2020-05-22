String added;
    @Override
    public void onClick(View v) {

        int a = 0;
        if (cb1.isChecked()) a+=400;
        if (cb2.isChecked()) a+=500;
        if (cb3.isChecked()) a+=300;
        if (cb4.isChecked()) a+=200;
        added = Integer.toString(a);
    }