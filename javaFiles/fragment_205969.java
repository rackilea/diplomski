b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        int a = Integer.parseInt(e1.getText().toString());
        t1.setText("Value in A: "+a);
    }
});