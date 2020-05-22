Button btn_copiar = (Button) findViewById(R.id.btn_copiar);
btn_copiar.setOnClickListener(new OnClickListener(){
public void onClick (View v) {
   try {
       asFtp = new asFTP();
       if (comprobar_preferencias()){
          Log.d(TAG, prefServidor + " " + String.valueOf(prefPuerto) + " " + prefUsuario + " " + prefPass);
    asFtp.setOnResultsListener(MainActivity.this); // here I get the eclipse error
    asFtp.execute();