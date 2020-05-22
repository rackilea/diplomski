Lab = (CheckBox)findViewById(R.id.LabCheck);
Lec = (CheckBox)findViewById(R.id.RoomCheck);

if(Lab.isChecked()) {
    LabText = "withlab";    
} else {
    LabText = "without";
}

if (Lec.isChecked()) {
    LecText = "corner";
} else {
    LecText = "notcorner";
}

Toast.makeText(this,LabText, Toast.LENGTH_SHORT).show();

Toast.makeText(this,LecText, Toast.LENGTH_SHORT).show();