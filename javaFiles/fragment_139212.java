MyHtml2Text parser = new MyHtml2Text();
try {
    parser.parse(new StringReader(myTextPane.getText()));
} catch (IOException ee) {
  //handle exception
}
System.out.println(parser.getText());