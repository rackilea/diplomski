checkBoxField[0].setChangeListener(new FieldChangeListener() {
        public void fieldChanged(Field field, int context) {

            if(context != FieldChangeListener.PROGRAMMATIC){  //It means manually clicked by User
                if(checkBoxField[0].getChecked()){
                    checkBoxField[0].setChecked(false);
                }else{
                    checkBoxField[0].setChecked(true);
                    //Please wait Screen starts
                    // call here a user defined function to populate the drop down list
                    //Please wait Screen ends
                }
            }else{
                checkBoxField[0].setChecked(false);
            }
        }
    });