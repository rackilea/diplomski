public static void test(){
    Character2 objectArray[][] = new Character2[8][8];
    ArrayList<Integer> x1 = new ArrayList<>();
    ArrayList<Integer> y1 = new ArrayList<>();
    ArrayList<Integer> x2 = new ArrayList<>();
    ArrayList<Integer> y2 = new ArrayList<>();
    ArrayList<Integer> junkx = new ArrayList<>();
    ArrayList<Integer> junky = new ArrayList<>();

    for (int row = 0; row < objectArray.length; row++){
        for(int col = 0; col < objectArray.length; col++){
            if (row <= 1 && col <= 7){
                objectArray[row][col] = new Character2();
                objectArray[row][col].setType("Test1");
                objectArray[row][col].setIdTest1(row,col);
                objectArray[row][col].objectFlag = true;

             }
             else if ((row == 6 || row == 7) && (col <= 7)){
                objectArray[row][col]= new Character2();
                objectArray[row][col].setType("Test2");
                objectArray[row][col].setIdTest2(row,col);
                objectArray[row][col].objectFlag = true;
             }
             else {
                objectArray[row][col]= new Character2();
                objectArray[row][col].setType("Test3");

             }
        }
    }
    for(Character2[] c2: objectArray){
        for(Character2 c: c2){
            System.out.print(" " + c.getType() );
        }
        System.out.println();
    }

    for (int x = 0; x < objectArray.length; x++){
        for (int y = 0; y < objectArray.length; y++ ){
            if (objectArray[x][y].getType().compareTo("Test1") == 0){
                x1.add(x);
                y1.add(y);
            }

            if (objectArray[x][y].getType().compareTo("Test2") == 0){
                x2.add(x);
                y2.add(y);
            }
            else{ 
                junkx.add(x);
                junky.add(y);
            } 
        }
    }

    System.out.print("Now the newly created array will be printed");
    for(int i : y2){
        System.out.println(i);
    }
}