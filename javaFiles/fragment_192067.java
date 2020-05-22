AlertDialog.Builder alt_bld = new AlertDialog.Builder(this, R.style.AlertDialogStyle);
alt_bld.setTitle("Select Date");


try{
    final View view = View.inflate(addAlarm.this, R.layout.alert_dialog_radiogroup, null);
    radioGroup = (RadioGroup)view.findViewById(R.id.radio);
    radioGroup.clearCheck();
    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
            //My code to handle checked radio button. 
        }

    });
    alt_bld.setView(view);
} catch (Exception e){
    e.printStackTrace();    
}

//setting +ve and -ve buttons here.
...

AlertDialog alert = alt_bld.create();
alert.show();