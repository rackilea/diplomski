try {
        PrintWriter fstream = new PrintWriter(new FileWriter("log.txt"));
    } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }


 for(String word : jTextAreaName.getText().split("\n"))  {    
    fstream.println(word); 
} 
     fstream.flush();