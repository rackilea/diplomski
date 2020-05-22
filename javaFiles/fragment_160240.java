while (c.moveToNext()){
    DBPronosticos curso = new DBPronosticos();

    curso.setFecha(c.getString(1));
    curso.setNombre_tipster(c.getString(3));
    curso.setEncuentro(c.getString(4));
    curso.setApuesta(c.getString(4));
    curso.setCuota(c.getDouble(4));
    curso.setCantidad_apuesta(c.getDouble(4));
    curso.setResultado(c.getString(4));

   //Add this line  
   list.add(curso);
}