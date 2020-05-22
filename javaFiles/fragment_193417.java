private void showNext(){
   if (mClickIndex == mAllStudent.size()){
      mClickIndex = 0; // start at beginning after end is reached.
   }
   Student lStudent = mAllStudent.get(mClickIndex);
   mClickIndex++;
   if (null != lStudent){
        txtCourse.setText(lStudent.getCourse());
        txtFName.setText(lStudent.getFirstname());
        txtMname.setText(lStudent.getMName());
        txtLname.setText(lStudent.getLastname());
        txtStdnt.setText(lStudent.getInfo());
        txtID.setText(lStudent.getId());
   }
}