// lets assume binary code where 0000 represents top, right, bottom, left 
// (0011 would mean can go bottom or left)
public int getVisitingDirection()
{
    String tmpBinary = "b"; // to initialize the field

    // check if can go up
    tmpBinary += (cCollums>0&&checkIfUpIsBlocked()) "1" : "0";
    // TODO check if can go right (compare with size + 1)
    // check if can go bottom (compare with size +1 )
    // check if can go left (check if > 0)

    // when this runs tmpBinary will be in the form of a binary representation
    // this will be passed to the robot that can then chooses where to go
    // 1111 would mean that all squares are clear to go
    // 1101 would mean top, right and left
    // etc...

}

private boolean checkIfUpIsBlocked()
{
    // TODO must check if the cell is blocked
    return true;
}