int numLine= 0;
while(sc.hasNextLine())
    {

        line = sc.nextLine();
        numLine++
        String[] fields = line.split("\\s+");
        if(fields.length != 6) {
           System.out.println("Error Line number:"+numLine);
           System.out.println("Number of fields on line must be 6, but it has :"+ fields.length);
        }
     }