Date date = new Date();
SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
String dateString = formatter.format(date);
formatText = new JFormattedTextField(createFormatter("##:##:##"));
formatText.setColumns(8);
formatText.setText(dateString);