BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\John\\workspace\\ggg\\src\\ggg\\text.txt"));
    String myLine;
    while ((myLine = br.readLine()) != null) {
       if(myLine.contains("8888888"))
           System.out.println(myLine.substring(myLine.indexOf(">")+1));
    }
    br.close();