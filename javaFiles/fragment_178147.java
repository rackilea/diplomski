int rowCount = 0;

try {
    Integer user = InformationService.authenticate(username, password, connection);
    Statement st = connection.createStatement();
    String query = "SELECT * FROM tasks WHERE uid = " + user + " ORDER BY title ASC";
    System.out.println(query);
    ResultSet rs = st.executeQuery(query);

    while (rs.next()) {
        Task p = new Task(rs.getString("title"), rs.getInt("id"), rs.getString("descriere"),
            rs.getString("data"), rs.getInt("uid"), rs.getString("data_creare"), rs.getString("ora"),
            rs.getInt("status"), rs.getString("priority"), rs.getInt("sters"), rs.getInt("id_parinte"),
            rs.getInt("notify"), rs.getString("assigner"), rs.getInt("durata"), rs.getInt("project_id"));

        rowCount++;
        System.out.println(rowCount + "." + p);
        tasks.add(p);
    }
} finally {
    System.out.println("Number of records = " + rowCount);
}