System.out.println("Message: ");

 final StringWriter sw = new StringWriter();

 int c;
 while ((c = is.read()) != -1) {
    sw.write(c);
 }

 String data = sw.toString();