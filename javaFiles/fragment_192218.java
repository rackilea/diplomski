for (int row = 0; row < 10; row++) { 
        for (int col = 0; col < 10; col++) {
            int cellStat = cellStatus(col, row);
            String shipSymbol = (cellStat == -1 ? "-" : Integer.toString(cellStat));
            System.out.print(shipSymbol+" ");
        }
        System.out.println();
    }