FileWriter fw = new FileWriter(filename,true); // <-- here!
while(data.hasNextLine()){                          
    String line = data.nextLine();
    String[] split = line.split("\t");
    String filename = "D:\\P&G\\March Sample Data\\" + split[0] + " "
            + split[1]+ ".txt";
    //System.out.println((filename));
    //System.out.println(line); 
    // FileWriter fw = new FileWriter(filename,true);