for(int i = 0; i<count; i++){
            String[] res = array.get(i);

             cod = new String[]{res[0]} ;
             desc = new String[]{res[1]};
             preco = new String[]{res[3]} ;
        }
        lista=(ListView)findViewById(R.id.list);
        lista.setAdapter(new dataListAdapter(cod, desc, preco));