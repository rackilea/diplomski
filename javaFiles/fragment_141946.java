String fileName=null;
boolean printFilename = false;    
while(scanner.hasNext()){
   String dLine = scanner.nextLine();
   if (dLine.matches("MATCHING_PATTERN1")){
       fileName = dLine;
       printFilename = true;
   }
   else{
       if (dLine.matches("MATCHING_PATTERN2")){
            if (printFilename) {        
                System.out.println(fileName);
                printFilename = false;
            }
            System.out.println(dLine);
        }
    }
}