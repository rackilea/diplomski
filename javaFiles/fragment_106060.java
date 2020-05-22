RadioGroup[] groups = new RadioGroup{RadioGroup1,RadioGroup2};

for(int i=0;i<groups.length;i++){

 int id = groups[i].getCheckedRadioButtonId();
 if(id==-1){

  isChecked=false;
  break; //break the loop, because if one is not checked, inform the user
 }else{

   isChecked=true;
  }
}