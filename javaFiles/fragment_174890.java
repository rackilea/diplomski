button1.setOnClickListener(new View.OnClickListener()
    {
        public void onClick(final View v)
        {


            if(sp1< record) {
                sp1++;
                lbl1.setText(String.valueOf(sp1));
            }
            else if(sp1>= record)
            {
                sp1++;
                record++;
                lbl1.setText(String.valueOf(sp1));
                lbl2.setText(String.valueOf(record));

            }

SharedPreferences data_record = getSharedPreferences("savegame", 0);
    SharedPreferences.Editor editor = data_record.edit();
    editor.putString("myKey1", String.valueOf(record));
    editor.commit();
        }
    });