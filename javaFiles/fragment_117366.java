public static void doCommand() throws IOException{
    String s = null;
    ProcessBuilder pb = new ProcessBuilder(commands); //definiramo procesBuilder
    Process proces = pb.start(); //zaženemo proces (vrne Process)

    final BufferedReader stdInput = new BufferedReader(new InputStreamReader(proces.getInputStream()));   //Branje outputa procesa
    final BufferedReader stdError = new BufferedReader(new InputStreamReader(proces.getErrorStream()));   //Branje error outputa

    Thread readStdIn = new Thread(new Runnable(){
        public void run(){
            try{
                while((s = stdInput.readLine()) != null){   //dokler output obstaja (ni error)
                    int dvop = s.indexOf(":") + 16;
                    if(s.startsWith("Reply")){
                        s=s.substring(dvop);
                        int pres = s.indexOf(" ");
                        s=s.substring(0,pres-2);
                        //System.out.println(s);

                        //Execute on the main AWT thread (I'm assuming 'label' is the name of one of your GUI components)
                        SwingUtilities.invokeLater(new Runnable(){
                            public void run(){
                                label.setText(s);
                            }
                        });
                    }
                }
            }catch(IOException ex){
                //Handle This
            }
        }
    });

    Thread readStdErr = new Thread(new Runnable(){
        public void run(){
            try{
                while((s = stdError.readLine()) != null){   //dokler error obstaja
                    System.out.println(s);
                }
            catch(IOException ex){
                //Handle This Too
            }
        };
    });

    readStdIn.start();
    readStdErr.start();
}