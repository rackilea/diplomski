ProcessBuilder pb2=new ProcessBuilder("/home/ahijeet/sample1.sh","--ip="+formobj.getUpFile().getFileName(),"--seqs="+seqs);

    script_exec = pb2.start();

            OutputStream in = script_exec.getOutputStream();

            InputStreamReader rd=new InputStreamReader(script_exec.getInputStream());   

            pb2.redirectError();

            BufferedReader reader1 =new BufferedReader(new InputStreamReader(script_exec.getInputStream()));

            StringBuffer out=new StringBuffer();

            String output_line = "";    

              while ((output_line = reader1.readLine())!= null) 
              {
                       out=out.append(output_line+"/n");
                       System.out.println("val of output_line"+output_line);

                       //---> i need code here to check that whether script is prompting for taking input ,so i can pass it values using output stream
                       if (output_line.equals("PLEASE INPUT THE VALUE:")) {
                           // output to stream
                           in.write("42");
                       }

              }