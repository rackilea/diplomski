if (car.getDir().equals("V")) {
     // go through every position before the current car's X
     for (int i = 0; ((i < car.getX()) && (i < (5 - car.getLen()) + 1)); i++) {
         // no car in current position? create new vehicle
         // instance
         if (isSafeVertical(b, car, i)) {
             Board copy = new Board(b.boardVehicles, b.moves, nextCar);
             copy.moveVehicle(i, car.getY(), b.currentCar);
             queue.add(copy);
         }
     }
     // go through every position after current car's x
     for (int i = car.getX() + 1; i < (5 - car.getLen()) + 1; i++) {
         // no car in current pos? create new vehicle instance.
             if (isSafeVertical(b, car, i)) {
                 Board copy = new Board(b.boardVehicles, b.moves, nextCar);
                 copy.moveVehicle(i, car.getY(), b.currentCar);
                 queue.add(copy);
             }
     }
     // move horizontal cars and add to queue