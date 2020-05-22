button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

        final String user = text.getText().toString();
        Intent in=new Intent(MainActivity.this,Tab.class);
        in.putExtra("SS",user);
        in.putExtra("NAME",user);
        Logger.d(user);

        startActivity(in);
    }
});