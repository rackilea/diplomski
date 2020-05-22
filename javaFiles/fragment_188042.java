public void onBindViewHolder(final OfertasAdapter.MyViewHolder viewHolder, int i) {

    // le enviamos el callback al metodo checkguardadas
    checkguardadas(11,new OnOfertasResponse(){

        @Override
        public void ofertas(ArrayList<Oferta> ofertas){
            // este metodo se ejecutara cuando onResponse se ejecute
            Iterator it = ofertas.iterator();
            while (it.hasNext()) {
                if (ofertaList.get(i).getId() == ofertas.get(i).getId()) {
                    viewHolder.guardar.setChecked(true);
                }
            }
        }
    })