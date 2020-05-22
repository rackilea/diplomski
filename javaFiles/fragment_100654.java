TableName papa = new TableName();
papa.setParent(null); // parent

    TableName kid1 = new TableName();
    kid1.setParent(papa);
    papa.getChildren().add(kid1);

        TableName kid1_1 = new TableName();
        kid1_1.setParent(kid1);
        kid1.getChildren().add(kid1_1);

    TableName kid2 = new TableName();
    kid2.setParent(papa);
    papa.getChildren().add(kid2);


session.save(papa)