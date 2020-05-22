boolean isMagicSquard = true;
int sum = -1;
for (int i = 0; i < matrix.length; i++){
    // Calculate the sum for each row
    int rowsum = 0;
    for (int j = 0; j < matrix[i].length; j++){
        rowsum += matrix[j][i];
    }
    if (sum == -1){ 
        sum = rowsum; 
    }else if (sum != rowsum){ // If the sum differs from the 
                              // first-row sum, it is no magic squaree
        isMagicSquard = false; break; 
    }
}
// The same code with rows and column swaped
for (int i = 0; i < matrix[0].length; i++){
    int columnsum = 0;
    for (int j = 0; j < matrix.length; j++){
        columnsum += matrix[i][j];
    }
    if (sum != columnsum ){ 
        isMagicSquard = false; break; 
    }
}
System.out.println(isMagicSquare);