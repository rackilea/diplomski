Button botonJugar = (Button) findViewById(R.id.botonJugar);

    botonJugar.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

               Intent  miIntent = new Intent(BingoPalabras.this,VentanaJugar.class);
                startActivity(miIntent);
            }
     }