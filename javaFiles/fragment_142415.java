Connection conn=DriverManager.getConnection(
        "jdbc:ucanaccess://C:/__tmp/unicode.accdb");
String language = "Greek";

PreparedStatement ps = conn.prepareStatement(
        "SELECT [word], [english_equiv] " +
        "FROM [vocabulary] " +
        "WHERE language=?");
ps.setString(1, language);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
    System.out.println(String.format(
            "\"%s\" is %s for \"%s\".", 
            rs.getString("word"),
            language,
            rs.getString("english_equiv")));
}
rs.close();
ps.close();

String newWord = "ηλεκτρονικός υπολογιστής";
String newEnglishEquiv = "computer";
ps = conn.prepareStatement(
        "INSERT INTO [vocabulary] ([word], [language], [english_equiv]) " +
        "VALUES (?,?,?)");
ps.setString(1, newWord);
ps.setString(2, language);
ps.setString(3, newEnglishEquiv);
ps.executeUpdate();
System.out.println(String.format(
        "\"%s\" has been added to the table.", 
        newWord));