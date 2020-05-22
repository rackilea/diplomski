final EditText et  = (EditText) findViewById(R.id.editText);
    final EditText et1 = (EditText) findViewById(R.id.editText2);
    final EditText et2 = (EditText) findViewById(R.id.editText3);
    Button btn = (Button) findViewById(R.id.button);

    btn.setOnClickListener(new View.OnClickListener() {

        public void onClick (View v){

            ArrayList<String> texts = new ArrayList<>();
            texts.add(et.getText().toString());
            texts.add(et1.getText().toString());
            texts.add(et2.getText().toString());

            Intent i = new Intent(MainActivity.this, postavke.class);
            i.putExtra("texts", texts);
            startActivity(i);
        }
    });
}