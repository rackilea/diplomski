edittext.setOnEditorActionListener(new OnEditorActionListener() {

        @Override
        public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {

            //I will store the matches on this list.
            List<Medico> resultado = new ArrayList<Medico>();
            int searchListLength = medicos.size();
            for (int i = 0; i < searchListLength; i++) {
            if (medicos.get(i).getNombre().contains(searchsds)) {
                // I found a match, I will add it to results
                resultado.add(medicos.get(i));
                }
            }
            //At the end, update the Adapter. I will assume that you have something like this.
            myAdapter.setValues(resultado);
            //You must write the code to set the values on your adapter. If you could post the way you are populating the list view I could help you out with more information.
return false;
        }
    });