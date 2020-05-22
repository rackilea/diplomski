RadioGroup radioGroup = (RadioGroup)findViewById (R.id.radioGroup1);
radioGroup.setOnCheckedChangedListener (new OnCheckedChangedListener(){
public void onCheckedChanged(RadioGroup group, int checkedId) 
{
  if (checkedId == R.id.radio0)
    group.setEnabled(false);
}
});