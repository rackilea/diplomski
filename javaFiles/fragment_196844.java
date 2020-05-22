int n = matrix.length;
        int m = matrix[0].length;
        ArrayList[][] neighbors = new ArrayList[n][m];

        for(int x=0; x<matrix.length; x++) {
            for(int y=0; y<matrix[0].length; y++) { //Iterate through length of column (y)
                neighbors[x][y]= new ArrayList<Integer>();
                if(matrix[x][y] != 0) {

                    //Checks pixels N,S,E,W of the current pixel
                    if (x-1 > 0 && labels[x-1][y]!=0)
                    {
                        neighbors[x][y].add(labels[x-1][y]);
                    }
                    if (x+1 < labels.length && labels[x+1][y]!=0)
                    {

                        //add neighbours
                        neighbors[x][y].add(labels[x-1][y]);
                    }
                    if (y-1 > 0 && labels[x][y-1]!=0 )
                    {
                        //
                        neighbors[x][y].add(labels[x-1][y]);
                    }
                    if (y+1 < labels[0].length && labels[x][y+1]!=0){
                        neighbors[x][y].add(labels[x-1][y]);
                    }

                }
            }
        }