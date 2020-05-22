boolean doShowToast = false;
    int[] textIDs = new int[] {R.id.etFirstName, R.id.etLastName, R.id.etEmail, R.id.etAddress, R.id.etCity, R.id.etRegion, R.id.etMobile, R.id.etLandLine, R.id.etYear, R.id.etMonth, R.id.etDay };
    for(int j=0; j<textIDs.length; j++) {
        EditText editText = (EditText) findViewById(textIDs[j]);
        if(editText.getText().toString().trim().equals(""))
        {// editText is empty
            Toast.makeText(MainActivity.this, "Request cannot performed..\n Please ensure all fields are filled", Toast.LENGTH_SHORT).show();
            break;
        } 
        else 
        {
             // editText is not empty
            doShowToast = true;
        }
    }
    if(doShowToast){
         Toast.makeText(MainActivity.this, "12", Toast.LENGTH_SHORT).show();
    }