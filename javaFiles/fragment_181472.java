btnChercherFournisseur.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            SearchFounisseurUi fen  = SearchFounisseurUi.getInstance();
            fen.setVisible(true);  /// !!! /// 
        }
    });