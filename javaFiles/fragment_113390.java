if( txtReg.getText().toString().trim().equals(""))
{
    txtReg.setError("required!");
}
if( txtCode.getText().toString().trim().equals(""))
{
    txtCode.setError("required!");
}
if( txtStreetName.getText().toString().trim().equals(""))
{
    txtStreetName.setError("required!");
}


else{
    final Button btnPay = (Button) findViewById(R.id.btnPay);

    btnPay.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent payIntent = new Intent(UserAreaActivity.this, PaymentActivity.class);// creates intent to open payment details
            UserAreaActivity.this.startActivity(payIntent);//Performs intent to open payment page
        }
    });

}