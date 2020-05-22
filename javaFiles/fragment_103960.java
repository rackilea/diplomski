public static void main(String args[]){
    String[][] matrix = {{"1","2","1","3",},{"7","6","null","2",},{"5","6","3","null",},{"3","10","9","5",}};
    System.out.println(findDuplicate(matrix));
}

public static int findDuplicate(String[][] matrix){
    String strArr[] = new String[(matrix.length)*(matrix[0].length)];
    int count = 0;
    for(int i = 0; i < matrix.length; i++){
        for(int j = 0; j < matrix[0].length; j++){
            for(int k = 0; k < matrix.length; k++){
                for(int l = 0; l < matrix[0].length; l++){
                    if((i!=k || j!=l)){
                        if(matrix[i][j] == matrix[k][l]){
                            int x = 0;
                            boolean flag = false;
                            while(strArr[x] != null){
                                if(null != matrix[i][j] && matrix[i][j].equals(strArr[x])){
                                    flag = true;                                    
                                }
                                x++;
                            }
                            if(flag==false){
                                strArr[count] = matrix[i][j];
                                count++;
                            }
                        }
                    }
                }
            }
        }
    }
    return count;
}