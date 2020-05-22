int temp1 = betterMove( valueMatrix, horizontal, vertical, accessibility, currentRow, currentColumn );

if( moveMade )  // if any move is possible
{
    currentRow += vertical[ temp1 ];
    currentColumn += horizontal[ temp1 ];
    // Rest of the code
}