String assembledString = "";
    View tempView;
    for(int i = 0; i < ll.getChildCount(); i++){
        tempView = ll.getChildAt(i);
        if(tempView instanceof EditText){
            assembledString += ((EditText) tempView).getText().toString();
        }
    }