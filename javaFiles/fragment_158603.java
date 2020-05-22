public void insertRecord() {
        try {
            String nome;
            //handle default value
            if (txtNome.getText().isEmpty()) {
                //nome = "Nuovo progetto";
                nome = mostraDefault("nome");
                System.out.println(nome); //this correctly prints its def val on stout
            } else {
                nome = txtNome.getText();
            }

            //query to insert
            String sql = "INSERT INTO ClassDiagram(Nome) VALUES(?)";
            conn = Database.nuovaConnessione();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nome);
            ps.executeUpdate();
...