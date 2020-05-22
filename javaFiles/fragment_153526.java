JsonArrayBuilder cellsBuilder=Json.createArrayBuilder();
            cellsBuilder.add("x1");
        cellsBuilder.add("X2");
        cellsBuilder.add("X3");
        cellsBuilder.add("X3");

    JsonArray cells=cellsBuilder.build();

    JsonObject rows =Json.createObjectBuilder()
        .add("id", "id_val1")
        .add("cells", cells).build();

    JsonObject dataUsers =Json.createObjectBuilder()
        .add("nume","total")
        .add("salariu","1000").build();

    JsonObject my_data =Json.createObjectBuilder()
        .add("rows", "rows")
        .add("dataUser", dataUsers).build();