if(resObj != null){

    if(resObj.getStatus()){

        Intent intent = new Intent(Login.this, ListActivity.class);
        intent.putExtra("your_key", resObj); // pass resObj and use same key to get data
        startActivity(intent);

    } else{
        Toast.makeText(Login.this, "Phone Number is incorrect!", Toast.LENGTH_SHORT).show();
    }
}