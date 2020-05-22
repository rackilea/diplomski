//Signature of method changed to add List<DVDInfo> as a parameter    

    public static void populateList(List<DVDInfo> info) throws Exception {
            BufferedReader br = new BufferedReader(new FileReader(new File("C:\\src\\dvdInfo.txt")));
            //read each line of dvdInfo.txt below
             String line = null;
             while ((line = br.readLine()) != null) { //check line in loop
                String[] tokens = line.split("/");
                DVDInfo infoItem = new DVDInfo(tokens[0],tokens[1],tokens[2]);
                info.add(infoItem);      
            } 
          }