// not tested
    query="SELECT * FROM dipendenti WHERE email=? AND password=?";
    PreparedStatement statement = connessione.prepareStatement(query);

    statement.setString(1, mail);
    statement.setString(2, pass);

    ResultSet resultSet = statement.executeQuery();