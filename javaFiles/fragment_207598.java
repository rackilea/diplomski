private void iterate() {
        for(int i=0; i < rows; i++) {
            for(int j=0; j < cols; j++) {
                if(map[i][j]=='Z'&& map[i][j]!='R') {
                    try{                
                        map[i][j+1]='Z';
                        map[i+1][j]='Z';
                        map[i+1][j+1]='Z';
                        map[i-1][j+1]='Z';
                        map[i-1][j]='Z';
                        map[i-1][j-1]='Z';
                        map[i+1][j-1]='Z';
                        map[i][j-1]='Z';
                    }
                    catch(IndexOutOfBoundsException e) {
                        System.out.println("smthg");
                    }
                }
            }
        }
    }