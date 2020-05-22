for(int x = 0; x < 9; x++){
        System.out.print("|     |     |     ||     |     |     ||     |     |     |\n");
        for(int y = 0; y < 9; y++){
            if(y == 0 || y == 3 || y == 6) System.out.print("|");
            System.out.print("  " + sudoku[x][y] + "  |");
        }
        System.out.print("\n");     
        System.out.print("|     |     |     ||     |     |     ||     |     |     |\n");
        if(x == 2 || x == 5)
            System.out.print("=========================================================");
        else
            System.out.print("---------------------------------------------------------");
        System.out.print("\n");
    }