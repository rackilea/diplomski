byte [] hashValue = HashClass.hash256Bytes(messageValue);

    //query = "insert into message values (?)";
    connection = ConnectionFactory.getConnection();
    //Blob blob = new javax.sql.rowset.serial.SerialBlob(hashValue);
    //Blob blob = new SerialBlob(hashValue);

    preStatement = (PreparedStatement) connection.prepareStatement(query);
    preStatement. setBytes(1, hashValue);
    rs = preStatement.executeQuery();