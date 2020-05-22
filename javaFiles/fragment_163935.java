while ((line = cfgFile.readLine()) != null) {
   if (!line.trim().equals("")) {
     String [] fields = line.split("\\|"); 
     callToRemoteWebService(fields[0]);
   } 
 }