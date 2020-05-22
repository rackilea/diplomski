if (rs.next()) {
    do {
        System.out.print(rs.getString("idUser") + " ,");
        System.out.print(rs.getString("Name") + " ,");
        System.out.print(rs.getString("Email") + " ,");
        System.out.println(rs.getString("country") + " .");
    } while (rs.next());
}