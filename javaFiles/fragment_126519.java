LinkedList<LinkedList<Integer>> list = new LinkedList<>();
int[][] myArray = { {1, 2, 3}, {4,5,6},{7,8,9} };
for (int i = 0; myArray.length >= i; i++) {
        LinkedList<Integer> auxList = new LinkedList<>();
          for (int j = 0; myArray[i].length >= j; j++) {
            auxList.add(myArray[i][j]);
        }
        list.add(auxList);            
 }