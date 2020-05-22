pstpr = con.prepareStatement("select id_prodotto from prodotto_autore where id_autore='" + id.getInt(1) + "';");
        prodotti = pstpr.executeQuery();
        while (prodotti.next()) {
            pstcoa = con.prepareStatement("SELECT id_autore FROM prodotto_autore  WHERE id_prodotto='" + prodotti.getString(1) + "';");
            coautori = pstcoa.executeQuery();
            List<String> row =null;
            row = new ArrayList<>();
            while (coautori.next()) {
                  // new list per row
                 row.add(coautori.getString(1));

                //prodott.add(coalizione.getString(2));
            }
            coaliz.add(row);
        }