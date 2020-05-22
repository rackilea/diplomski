isDyg = true; 
        outerloop:    
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if((i != j) && (matrix[i][j] != 0)){
                    isDyg = false;
                    break outerloop;
                }

            }
            //System.out.print("");
        }
        return isDyg;