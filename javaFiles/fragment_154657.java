user = new users();
btnsave.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Long phn = Long.parseLong(etphonenumber.getText().toString());
        Long mob = Long.parseLong(etmobilenumber.getText().toString());
        user.setCnic(etcnic.getText().toString());
        user.setFinyear(etfinalyear.getText().toString());
        user.setName(etname.getText().toString());
        user.setPaygroup(etpaygroup.getText().toString());
        user.setDirectorate(etregion.getText().toString());
        user.setCurrentposition(etcurrentposition.getText().toString());
        user.setResidentialaddress(etcurrentaddress.getText().toString());
        user.setPhonenumber(phn);
        user.setMobilenumber(mob);
        DatabaseReference newRef = reff.child("user1").push();
        newRef.setValue(user);
        //reff.push().setValue(user);
        Toast.makeText(HomeActivity.this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
    }
});