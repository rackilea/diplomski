differenceX = roomCenterPosX[connectRooms[0]] - roomCenterPosX[connectRooms[1]];
        differenceY = roomCenterPosY[connectRooms[0]] - roomCenterPosY[connectRooms[1]];
        if(roomCenterPosX[connectRooms[0]] < roomCenterPosX[connectRooms[1]])
            differenceX *= -1;
        if(roomCenterPosY[connectRooms[0]] < roomCenterPosY[connectRooms[1]])
            differenceY *= -1;