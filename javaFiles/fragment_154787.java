private void checkFails(){
    TextView failsleft = (TextView) findViewById(R.id.fails);
    if(fails < 1){
        failsleft.setText("Fails left: "+fails);

        // Send the result back to main activity
        Intent i = getIntent();
        // you can add any extra here, for example, game state.
        // i.putExtra("extra_key", value);
        setResult(Activity.RESULT_OK, i);

        // Finish the GameActivity because we don't need it anymore.
        finish();

    }else{
        failsleft.setText("Fails left: "+fails);
        fails--;
    }
}