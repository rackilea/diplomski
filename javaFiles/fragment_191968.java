if (set.next()) {
    String role = set.getString("role");

    Menu menu = new Menu();
    menu.setVisible(true);
    setVisible(false);

    menu.Proba(role);

    stmt.close();
    connection.close();
}