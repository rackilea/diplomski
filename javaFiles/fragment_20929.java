BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
while(true){
    String textToSend = null;
    try {
       textToSend = reader.readLine();
       System.out.println("read text: " + textToSend);
    } catch (IOException e) {
        e.printStackTrace();
    }
    printer.print(textToSend + "\n");
    printer.flush();
    System.out.println("text send");
 }