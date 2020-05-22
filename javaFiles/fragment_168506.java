TextView textViewToResponse = findViewById(R.id.textviewtoresponse);

public void setVaraible(int value) {
    variable = value;
    if (variable==0){
        textViewToResponse.setVisibility(GONE);
    }
    else{
        // do something else
    }
}