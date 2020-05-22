while ((line = is.readLine()) != null)
       {
           System.out.println(line);
           if(line.toLowerCase().matches(".*enter.*password.*"))
           {
               System.out.println("Writing password for the user");
               os.write(password);
               os.write(System.getProperty("line.separator"));
               os.close();
           }
       }