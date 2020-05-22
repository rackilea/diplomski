if (X > (screenW-playButtonUp.getWidth())/2 &&   // ( = 3, ) = 2; Nested level: 1
    X < ((screenW-playButtonUp.getWidth())/2) +  // ( = 3, ) = 3; Nested level: 1
              playButtonUp.getWidth()) &&        // ( = 1, ) = 2; Nested level: 0
    Y > (int)(screenH*0.45) &&                   // ( = 2, ) = 2; Nested level: 0
    Y < (int)(screenH*0.45) +                    // ( = 2, ) = 2; Nested level: 0
    playButtonUp.getHeight()) {                  // ( = 1, ) = 2; Nested level: -1?!?
        playButtonPressed = true;                // Total ( = 12, ) = 13
    }