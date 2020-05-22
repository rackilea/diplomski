int[] commandPercentages = {75, 15, 10};        
    int randomNumber = 90;

    if((randomNumber -= commandPercentages[0]) < 0) {
        //Execute Command A
    }
    else if((randomNumber -= commandPercentages[1]) < 0) {
        //Execute Command B
    }
    else {
        //Execute Command C
    }