ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, configureList(idRuta, rocodromo, dificultad)) 
      {
          @Override
          public View getView(int position, View convertView, ViewGroup parent) 
          {

              View view = super.getView(position, convertView, parent);
              TextView text = (TextView) view.findViewById(android.R.id.text1);


                 if(colores.get(position).equals("0"))
                 {
                     text.setBackgroundColor(Color.GREEN);
                 }
                 else if(colores.get(position).equals("1"))
                 {
                     text.setBackgroundColor(Color.RED);
                 }
                 else if(colores.get(position).equals("2"))
                 {
                     text.setBackgroundColor(Color.YELLOW);
                 }
                 else
                 {
                     text.setBackgroundColor(Color.WHITE);
                 }


             return view;
          }
      };