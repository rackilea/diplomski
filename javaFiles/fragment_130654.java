private static void ShowGrid(CellCondition[][] currentCondition) {
    int x = 0;
    int rowLength = 5;

    for(int i = 0; i < currentCondition.length; i++) {
        for(int j = 0; j < currentCondition[0].length; j++) {
            CellCondition condition = currentCondition[i][j];
            String output = (condition == CellCondition.Alive ? "O" : "·");
            System.out.print(output);
            x++;
            if(x >= rowLength) {
               x = 0; 
               System.out.println();
            }
        }
    }
}