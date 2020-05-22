if(currentState[0][0]==4 && currentState[1][0]==4 && currentState[2][0]==4 &&currentState[3][0]==4) {
    // the system is full, arrivals get lost
    loss++;
} else{                  
    for(int j=0;j<4;j++) {
        if(currentState[j][0]==4) { 
            currentState[j][0]=currentState[j+1][0];
            System.out.println("The currentState is "+currentState[j][0]);
        }
        else {                
            currentState[j][0] = currentState[j][0]+1;
        } // close if block, used for checking or incrementing the state of each server   
    } // close for used for checking or incrementing the state of each server to the next one
} // close the if block which check if the system if full or not
arrivals++;