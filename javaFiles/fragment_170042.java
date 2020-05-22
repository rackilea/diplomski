public static void main(String[]args) {        
    int nbrVariables = 2;
    int nbrCombinaisons = (int) Math.pow(2, nbrVariables);

    boolean tt [][] = new boolean [nbrCombinaisons][nbrVariables+1];        
    for (int j = 0; j < nbrCombinaisons; j++) {             
        String    tempStr  = String.format("%"+nbrVariables+"s", Integer.toBinaryString(j)).replace(" ", "0");
        boolean[] tempBool = new boolean[tempStr.length()+1];
        boolean total = tempStr.charAt(0)=='1';
        for(int i=0; i<tempStr.length(); i++){
            tempBool[i]= tempStr.charAt(i)=='1';
            if(i>0){
                total = total && tempBool[i];  //table for logical AND change operator to || for OR or ^ for XOR
            }
        }
        tempBool[tempStr.length()] = total;
        tt[j] = tempBool;
    }

    for (boolean[] row : tt) {            
        for (boolean c : row) { 
            System.out.print(c + "\t");        
        }
        System.out.println();
    }      
}