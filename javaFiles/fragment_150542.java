for(String gene : s1.data()) {
    int counter = 0; //Moved inside the for loop, so that it always starts at 0
    for (char cORg : gene.toCharArray()) {
        if ((cORg == 'c') || (cORg == 'g')) {
            counter ++;
        }

        System.out.print(gene +" ");
    }

    //Floating point division, instead of integer division
    float cgRatioGenes =  ((float)counter)/gene.length(); 
    System.out.println("cgRatio:  " + cgRatioGenes);
}