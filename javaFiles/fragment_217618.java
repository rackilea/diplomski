listView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        Toast.makeText(getApplicationContext(),
                listView.getItemAtPosition(0).toString(),
                Toast.LENGTH_LONG).show();
    }
});