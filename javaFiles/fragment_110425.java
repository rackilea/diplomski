public void boardPassenger( int destinationFloorNumber ) {
try{
            if ( passengerCount == CAPACITY ) {
                   throw new ElevatorFullException();
            }
            passengerLeaving[destinationFloorNumber - 1] += 1;      
        isDestination[destinationFloorNumber -1] = true;
        passengerCount += 1;
    }
    catch (ElevatorFullException ee){
       //do any processing you need when exception is thrown
    } }