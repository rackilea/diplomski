Implement onCheckChangeListener
teacher = (CheckBox) findViewById(R.id.chkTeacher);
        student = (CheckBox) findViewById(R.id.chkStudent);

  teacher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
if(isChecked){

    type = "teacher";
        }
        else{
            type = "student";
        }
     }
        });