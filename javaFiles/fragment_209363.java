try{
    dateChooser.setDateFormatString("yyyy-MM-dd HH:mm:ss");
    dateChooser.setBounds(419, 89, 175, 20);
    frame.getContentPane().add(dateChooser);

    final String start = (((JTextField)dateChooser.getDateEditor().getUiComponent()).getText());

    DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime startDate = LocalDateTime.parse(start ,format);
    LocalDateTime endDate = LocalDateTime.now();
}
catch(ParseException e){
    e.printStackTrace();
}