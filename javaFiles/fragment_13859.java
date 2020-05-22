public static void main (String[] args) throws Exception
    {
         File    foldersContainer  = new File("c:/test");
         String  latestFileName    = "";
         Integer highestFileNumber = 0;

         for (File tmpFile : foldersContainer.listFiles()){
             if (tmpFile.isFolder()) {
                int currentNumber = extractFileNumber(tmpFile.getName());
                if (currentNumber > highestFileNumber){
                   highestFileNumber = currentNumber;
                   latestFileName    = tmpFile.getName();
                }
             }
         }             
         latestFileName.replace(highestFileNumber.toString(),
                                (++highestFileNumber).toString());
         System.out.println("Latest file (incremented): " + latestFileName);
    }


    private static int extractFileNumber(String name){          
        for (int x=name.length()-1; x >= 0; x--) 
            if (!Character.isDigit(name.charAt(x))) 
                return Integer.parseInt(name.substring(x+1));
        return -1;
    }