public Direction nextMove() {
    if (xCar < xDestination){
        xCar = xCar + car.x+ 1;
    }
    else if (xCar > xDestination){
        xCar = xCar + car.x -1;
    }
    else if (yCar < yDestination){
        yCar = yCar + car.y +1;
    }
    else if (yCar > yDestination){
        yCar = yCar + car.y -1;
    }
    return null;