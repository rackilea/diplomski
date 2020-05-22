public static String[] mergeStrings(String[]...matrix){
    int total = 0;
       for(String[] vector : matrix){
             total += vector.length;
       }
       String[] resp = new String[total];

       for(int i=0; i< matrix.length; i++){
           for(int j=0; j< matrix[i].length; j++){
                resp[i*matrix.length + j] = matrix[i][j];
           }
       }
       return resp;
}