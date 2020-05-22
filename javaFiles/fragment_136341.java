if (name != null &&
    passengers[i] != null && 
    name.equalsIgnoreCase(passengers[i].getName()))
{
    //...code here
    if (flights[i] != null){
       flights[i].decreaseBookedSeats();
    } else {
       // should not happen
    }
    // .. more code
 }