boolean found = false;
while(inventorySC.hasNextLine()){
    String lineFromFile = inventorySC.nextLine();
    if(lineFromFile.equals(partID)) {       
     partFileDesc = inventorySC.nextLine();
     partFilePrice = inventorySC.nextLine();
     partFileLoc = inventorySC.nextLine();
     partFileQuan = inventorySC.nextLine();

      System.out.println("Part I.D. Number: " + partFileID + "\n");
                              System.out.println("Part Description: " + partFileDesc + "\n"
                                       + "Part Price: " + partFilePrice + "\n"
                                       + "Part Location: " + partFileLoc + "\n"
                                       + "Part Quantity: " + partFileQuan);
                              found = true;
                             break;
                        }
            }

if(!found)
    System.out.println("Sorry, this part cannot be found");