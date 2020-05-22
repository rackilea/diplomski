for(j=max;j>=1;j--){                  //For each possible height of the histogram.
    for(k=0;k<repetition.length;k++)  //Check height of each element
        if(repetition[k]>=j)
            System.out.print("*");    //Print * if the k-th element has at least a height j.
        else
            System.out.print(" ");    //Else, do print blank space
    System.out.println();             //Newline after every row.
}