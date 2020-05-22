String[] Contestants = {"Bob","Bill","Chris","John","Michael"};

int[][] contPlace=new int[Contestants.length][4];
String file = "test.txt";

public FileParsing() throws Exception {
    Arrays.fill(contPlace[0], 0);
    Arrays.fill(contPlace[1], 0);
    Arrays.fill(contPlace[2], 0);
    Arrays.fill(contPlace[3], 0);
    BufferedReader br = new BufferedReader(new FileReader(file));
    String strLine;
    while((strLine=br.readLine())!=null){
        String[] line = strLine.split(",");
        System.out.println(line[0]+"/"+line[1]+"/"+line[2]+"/"+line[3]+"/"+line[4]);
        if(line[0].equals("Game Event")){
            //line[1]==1st place;
            //line[2]==2nd place;
            //line[3]==3rd place;
        }else{//we know we are on a game line, so we can just pick the names
            for(int i=0;i<line.length;i++){
                for(int j=0;j<Contestants.length;j++){
                    if(line[i].trim().equals(Contestants[j])){
                        System.out.println("j="+j+"i="+i+Contestants[j]);
                        contPlace[j][i-1]++; //i-1 because 1st substring is the game name
                    }

                }
            }
        }
    }
    //Now how to get contestants out of the 2d array
    System.out.println("Placement  First Second Third Fourth");
    System.out.println(Contestants[0]+" "+contPlace[0][0]+" "+contPlace[0][1]+" "+contPlace[0][2]+" "+contPlace[0][3]);
    System.out.println(Contestants[1]+" "+contPlace[1][0]+" "+contPlace[1][1]+" "+contPlace[1][2]+" "+contPlace[1][3]);
    System.out.println(Contestants[2]+" "+contPlace[2][0]+" "+contPlace[2][1]+" "+contPlace[2][2]+" "+contPlace[2][3]);
    System.out.println(Contestants[3]+" "+contPlace[3][0]+" "+contPlace[3][1]+" "+contPlace[3][2]+" "+contPlace[3][3]);
    System.out.println(Contestants[4]+" "+contPlace[4][0]+" "+contPlace[4][1]+" "+contPlace[4][2]+" "+contPlace[4][3]);

}