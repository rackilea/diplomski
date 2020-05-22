String query = "";
    while ((komut = bf.readLine()) != null) {
       if (komut.length() != 0) {
            if (komut.charAt(komut.length() - 1) == ’;’) {
                komutVektoru.add(query + "\n"+ komut);
                query = "";
            } else {
                query += komut;
            }
       }
    }