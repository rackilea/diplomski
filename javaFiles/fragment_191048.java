@Override
public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
       CheckBox checkbox;
       if (buttonView instanceof CheckBox )
       {
           checkbox = (CheckBox)buttonView;
       }
       else return;

       if (isChecked) {
            selected.add(checkbox.getText().toString());
       }else{
            selected.remove(checkbox.getText().toString());
       }
}