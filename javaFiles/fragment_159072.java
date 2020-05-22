checkboxbutton.setOnCheckedChangeListener(new OnCheckedChangeListener(){

    public void onCheckedChanged(CompoundButton arg0, boolean isChecked){

        if (isChecked){   
            CheckBox cb1 = (CheckBox) findViewById(R.id.check1);
            SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
            cb1.setChecked(settings.getBoolean("MY_NAME",true));
            String s1="OK"; 
            AlertDialog.Builder ad=new AlertDialog.Builder(IPCamera.this);
            ad.setMessage("CHECKBOX SET");
            ad.setPositiveButton(s1, new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                }
            });
            ad.show();
        }
    }
});