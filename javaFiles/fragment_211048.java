int totalValid=0,totalInvalid=0;

try {
            Scanner filescan = new Scanner(inputfile);
            while (filescan.hasNext()){
                aLine = filescan.nextLine();

                Token = aLine.split(separator);

                if (Token.length == 3){
                    System.out.println(Token[0]+"\t €" +Token [1]+"\t"+Token[2]);
                    ++totalValid;
                } else {
                    //REMOVED THE throw new IllegalArgumentException(
                    ++totalInvalid;
                }
            }

                System.out.println("Valid transactions : " + totalValid);
                System.out.println("Invalid transactions : " + totalInvalid);

            filescan.close();
            System.out.println("End of transaction \n================================\n\n");

        } catch (FileNotFoundException e)
    {
        System.out.println("problem "+e.getMessage());
    }