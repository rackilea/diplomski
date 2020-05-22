@Override
    public void afterTextChanged(Editable s)
    {    
       String sText = ET.getText().toString()

        if( !isFormatted(sText))
             s = format(sText);              
    }
    bool isFormatted(String s)
    {
     //check if s is already formatted
    }

    string format(String s)
    {
      //format s & return
    }