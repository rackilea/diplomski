for (int i = 0; i < numArcs; i++){
    for (int j = 0; j < numNodes; j++){
        if (matriz[j][i] != 0)
            break;
            //It finds a number != 0 so it should move to the next column 

        //If it gets here, the whole column was full of zeros
        column = i; 
        key = true;
        break outerloop;
    }
}