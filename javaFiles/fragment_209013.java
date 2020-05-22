@Override
        public void onEntrada(Object entrada, View view) {
            if(entrada != null) {
                ImageView img = (ImageView)findViewById(R.id.image);
                if(img != null) {
                    img.setImageResource(((Entrada) entrada).getImagen());
                }
                TextView t = (TextView)findViewById(R.id.lblInfo);
                if(t != null) {
                    t.setText(((Entrada) entrada).getInfo());
                }
                t = (TextView)findViewById(R.id.lblUrl);
                if(t != null) {
                    t.setText(((Entrada)entrada).getUrl());
                }
            }
        }