int size = 10;
        int [][] maze = new int[size][size];
        while (true){
            System.out.print(' ');
            for (int i = 0; i < size; i++) {
                System.out.print('|');
                System.out.print((char) ('A' + i));
            }
            for (int i = 0; i < size; i++) {
                System.out.println("");
                System.out.print(i);
                for (int j = 0; j < size; j++) {
                    System.out.print('|');
                    if(maze[i][j] > 0) {
                        System.out.print(maze[i][j]);
                    } else {
                        System.out.print(' ');
                    }
                }
            }
            int row = -1;
            int col = -1;
            System.out.println("\nEnter CoOrdinates");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if(input.length() == 2) {
                char charAt = input.charAt(0);
                if(charAt >= 'A' && charAt <= 'A'+size-1) {
                    col = charAt-'A';
                }
                charAt = input.charAt(1);
                if(charAt >= '0' && charAt <= '0'+size-1) {
                    row = charAt-'0';
                }
                if(row != -1 && col != -1) {
                    System.out.println("Enter Action");
                    input = scanner.nextLine();
                    int action = Integer.parseInt(input);
                    maze[row][col] = action;
                } else {
                    System.out.println("Incorrect Input");
                }
            }
        }