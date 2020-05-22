if (mapWidth - 1 == xCoord) { 
    yCoord++;
    xCoord = 0;

    // add this:
    if (mapWidth - 1 == yCoord) { 
        break;
    }
}