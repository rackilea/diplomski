public static void createseq() {

    try {

        File file = new File("d:\\words.txt"); //Hardcoded file for testing locally
        BufferedReader br = new BufferedReader(new FileReader(file));
        HashMap<String,Integer> counter = new HashMap<String, Integer>();
        String line;

           while((line = br.readLine())!= null)
           {
               String[] actionID = line.split(",");
               String firstName = actionID[0];

                 if(counter.containsKey(firstName))
                 {
                     counter.put(firstName, counter.get(firstName) + 1);
                 }
                 else
                 {
                     counter.put(firstName,0);
                 }
               System.out.println(line+" "+counter.get(firstName));
           }
          br.close();
    } catch(Exception letterproof) {
         letterproof.printStackTrace();
     }
}