void modelsRadio () throws SQLException {

    JPanel modelsRadioPanel = new JPanel();

    Statement statement = db.setConnection();
    ResultSet rs = statement.executeQuery("SELECT * FROM МОДЕЛИ");
    ButtonGroup modelRadioGroup = new ButtonGroup();

    while (rs.next()) {

       JRadioButton jr = new JRadioButton(rs.getString("НАЗВАНИЕ"));
       //modelRadioGroup.add(new JRadioButton(rs.getString("НАЗВАНИЕ")));
       modelRadioGroup.add(jr);
       modelsRadioPanel.add(jr);   
    }

    frame.add(modelsRadioPanel);
}