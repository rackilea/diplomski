query.select(root).where (
    builder.equal ( root.get ( "id" ).get ( "codEstablec" ) , establecimiento),
    builder.equal ( root.get ( "id" ).get ( "correlGrupo" ) , correlGrupo),
    builder.equal(builder.function("YEAR", Integer.class, root.get("DATE_FIELD") ), C.YEAR),
    builder.equal(builder.function("MONTH", Integer.class, root.get("DATE_FIELD")), C.MONTH) 
    );