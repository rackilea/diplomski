PreparedStatement instruction = connection.prepareStatement("select * from gestionticket.user where login = ? and password = ?");
instruction.setString(1, Username);
instruction.setString(2, Password);
ResultSet resultat  = instruction.executeQuery();

if (resultat.next()) {
    System.out.println("Successful Login!\n----");
} else {
    System.out.println("Incorrect \n----");
}