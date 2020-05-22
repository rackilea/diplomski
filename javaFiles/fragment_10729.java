class checksumFinder {

public static long l1 = 1;
public static long l2 = 0;
//Default to not equal

String HexFinder(JFileChooser inFileName, String line, String Hex1, String Hex2)
throws FileNotFoundException, IOException {

    File file = inFileName.getSelectedFile();
    BufferedReader reader = new BufferedReader(new FileReader(file));

    try {

      line = reader.readLine();//Read all lines up to "[Device|Sensors|Checksum]"

      do {//Read line then check if line is "[Device|Sensors|Checksum]" WHILE isn't ";end of section [Device|Sensors|Checksum]"                    

        line = reader.readLine();

        if (line.equals("[Device|Sensors|Checksum]")) { //IF line is "[Device|Sensors|Checksum]" then  
                                                        //(check if line is "Value") ELSE read next line                    
          do {// DO read line and check line is "Value" WHILE line doesn't contain "Value"

            if (line.contains("Value")) { //IF line is "Value" then retrieve necessary value
                                          // ELSE read next line

              Hex1 = line.split("=")[1].trim();
              l1 = Long.parseLong(Hex1.substring(2), 16);
              JFrame frame1 = new JFrame("JOptionPane showMessageDialog example");
              JOptionPane.showMessageDialog(frame1, "Value has hex number\n " + Hex1 + "\n\n and integer\n" + l1 + "\n");

              System.out.println("Here's the line read  " + line);
              System.out.println("Here's the hex number from the line  " + Hex1);
              System.out.println("Here's the integer from the hex number  " + l1 + "\n");

              break;
            }
          } while (!"Value".contains(line = reader.readLine()));//while2   

          line = reader.readLine();  //Read the line AFTER first "Value" has been found

          do {//Read line and check if line has "Value" WHILE line doesn't contain "Value"

           if (line.contains("Value")) { // IF line is "Value" then retrieve necessary value
                                        // ELSE read next line

             Hex2 = line.split("=")[1].trim();
             l2 = Long.parseLong(Hex2.substring(2), 16);
             JFrame frame2 = new JFrame("JOptionPane showMessageDialog example");
             JOptionPane.showMessageDialog(frame2, "Value has hex number\n " + Hex2 + "\n\n and integer\n" + l2 + "\n");

             System.out.println("Here's the line read  " + line);
             System.out.println("Here's the hex number from the line  " + Hex2);
             System.out.println("Here's the integer from the hex number  " + l2 + "\n");

             break;
           }
         } while (!"Value".contains(line = reader.readLine()));//while3

         while (!";end of section [Device|Sensors|Checksum]".equals(line)){
            line = reader.readLine();
         }
       }
     } while (!";end of section [Device|Sensors|Checksum]".equals(line)); //while1

     if (l1 == l2) {
       JOptionPane.showMessageDialog(null, "Both checksum values ARE equal!");
       int status1 = 0;
       System.exit(status1);
     } else {
       JOptionPane.showMessageDialog(null, "Both checksum values NOT equal");
       int status2 = 0;
       System.exit(status2);
     }

 } catch (IOException e) {
      System.out.println("IO Exception. Could not read file!");
 }
   return null;
}