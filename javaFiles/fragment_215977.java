for(int i=0; i < x.length; i++){  // Selects one dice
        for(int j = i + 1; j < x.length; j++){  // Select another dice
            for(int k=0; k<x[i].length; k++){  // selects face of first dice
                for(int l=0; l<x[j].length; l++){  // select face of 2nd dice
                    System.out.print("Dice " + i + " Face " + k + " vs Dice " + j + " Face " + l);
                    System.out.println(" ==> " + x[i][k]+ " - " + x[j][l]);
                }
            }
        }
    }