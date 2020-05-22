int[][] numbers = {
                {3, 2, 5},
                {1, 4, 4, 8, 13},
                {9, 1, 0, 2},
                {0, 2, 6, 3, -1, -8}
        };

        int max = 0;


//Adding each row in the array
        int sum;
        for(int r = 0; r < numbers.length; r++) {
            sum = 0;
            for(int c = 0; c < numbers[r].length; c++) {
                sum += numbers[r][c];
                if(numbers[r].length > max){
                    max = numbers[r].length;
                }
            }
            System.out.println("Sum of row: " + sum);
        }
        System.out.println("Max " + max);

//Adding each column in the row
        int sum2;
        for(int c = 0; c < max; c++) {
            sum2 = 0;
            for(int y = 0; y < numbers.length; y++){
                if(numbers[y].length > c){
                    sum2 += numbers[y][c];
                    System.out.println(numbers[y][c]);
                }
            }
            System.out.println("Sum of column: " + sum2);
        }
    }