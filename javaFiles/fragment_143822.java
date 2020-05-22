public void start() {
    AccessController.doPrivileged(new PrivilegedAction<Object>(){
        @Override
        public Object run() {
            try{
              BufferedReader br=new BufferedReader(new FileReader(new File("database.txt")));
              BufferedWriter br2=new BufferedWriter(new FileWriter(new File("database1.txt")));

              String st;
              while((st=br.readLine())!=null){
                String []str=st.split(";");
                br2.write(st+"\n");
              }
            }
            catch(IOException e){}        
                //catch your exceptions
            }
        }               
    });
}