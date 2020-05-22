if( txtReg.getText().toString().trim().equals("")){
    txtReg.setError("required!");
}else{

    if((txtCode.getText().toString().trim().equals("") && !txtStreetName.getText().toString().trim().equals("")) || 
            (!txtCode.getText().toString().trim().equals("") && txtStreetName.getText().toString().trim().equals(""))){
        Intent payIntent = new Intent(UserAreaActivity.this, PaymentActivity.class);// creates intent to open payment details
        UserAreaActivity.this.startActivity(payIntent);//Performs intent to open payment page
    }else{
        //show message enter either code or street name not both
}