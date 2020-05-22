JSONObject obj = new JSONObject();
        obj.put("Note", note);
        JSONArray objArticoli=new JSONArray();
        for(int i=0; i<Articoli.size(); i++)
        {
            JSONObject articloliItem = new JSONObject();
            articloliItem.put("Codice", Articoli.get(i).GetCodice());
            articloliItem.put("Descrizione", Articoli.get(i).GetDescrizione());
            articloliItem.put("Prezzo", Articoli.get(i).GetPrezzo());
            objArticoli.put(articloliItem);

        }
        obj.put("Articoli",objArticoli);