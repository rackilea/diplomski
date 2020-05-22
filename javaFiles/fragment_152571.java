for(int i = 0; i < caloriesOfTheWeekArray.length; i++){
            String columnArray [] = textReader.readLine().split(" ");
            caloriesOfTheWeekArray[i] = new int[columnArray.length];
            for (int j = 0; j < columnArray.length; j++){
                caloriesOfTheWeekArray[i][j] = Integer.parseInt(columnArray[j]);
            }
        }