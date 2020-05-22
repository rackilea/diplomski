public void odbierz() throws IOException {
      String str;

       if(in.ready()) {
           str=in.readLine();  
           System.out.println("<Nadeszlo:> " + str);
       } else { 
           System.out.println("Zajetre");
       }
}