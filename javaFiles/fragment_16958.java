...
 List<Receta> recetas = new ArrayList<Receta>();

   query = "SELECT * FROM  RecetaTable";
        stmt = dbCon.createStatement();
        rs = stmt.executeQuery(query);

        while (rs.next())
        {
            Receta rec = new Receta();
            rec.setNombreReceta(rs.getString("nombreReceta"));
            // and so on
            recetas.add(rec);
        }

        return recetas;