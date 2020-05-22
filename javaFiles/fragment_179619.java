for(int j=0;j<4;j++) {
    if(currentState[j][0]==4) {                       
    //Here I have RunTime error
        currentState[j][0]=currentState[j+1][0]; //this is no logical
        System.out.println("The currentState is "+currentState[j][0]);
    }