View view_ = (View)findViewById(R.id.dictl_l);
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(getResources().getString(R.string.l_word) + main)
                .setView(someLayout);
        AlertDialog dlg = builder.create();
        dlg.show();