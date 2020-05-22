textPane = new JTextPane();
textPane.setContentType("text/html");
String htmlString = "<html><body width=\"595\" height=\"842\">
   <div align=\"left\"><img src=\"" + this.getClass().getClassLoader()
   .getResource("images/logo_html.png").toString()+"\" /></div>.....";
textPane.setText(htmlString);