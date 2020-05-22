SharedPreferences pref = getApplicationContext().getSharedPreferences("RadioPref", MODE_PRIVATE); 
Editor editor = pref.edit();

//save data in shared preference on button click
builder.setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int id) {
        Data.ifMale = ifMale;
        checkedRadio = rg.getCheckedRadioButtonId();
        System.out.println("numer radio" +checkedRadio);
        editor.putInt("checkedId", checkedRadio); 
    }
});
//get checkedId from shared preference and check that radion button.
int checkedId = pref.getInt("checkedId", -1);
if(checkedId != -1)
{
    //rg.check(checkedId);
    RadioButton rbutton =(RadioButton)findViewById(checkedId);
    rbutton.setChecked(true);
}