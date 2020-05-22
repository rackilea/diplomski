CheckBox[] cba;      

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    cba = new CheckBox[]{
            (CheckBox)findViewById(R.id.check1),
            (CheckBox)findViewById(R.id.check2),
            (CheckBox)findViewById(R.id.check3),
            (CheckBox)findViewById(R.id.check4),
            (CheckBox)findViewById(R.id.check5),
            (CheckBox)findViewById(R.id.check6)
    };
    //here set onChechedChange for all your checkboxes
    for (CheckBox cb:cba) {
        cb.setOnCheckedChangeListener(cbListener);
    }

 }

CompoundButton.OnCheckedChangeListener cbListener = new CompoundButton.OnCheckedChangeListener() {
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        checkEnoughAndMakeDisabled(cba);
    }
};

private void checkEnoughAndMakeDisabled(CheckBox checkBoxes[]){
    int countChecked =0;
    for (CheckBox cb:checkBoxes){
        cb.setEnabled(true);
        if (cb.isChecked()) countChecked++;
    }
    //your variable
    if (a <= countChecked) {
        for (CheckBox cb:checkBoxes){
            if (!cb.isChecked())cb.setEnabled(false);
        }
    }
}