if(position.y>50)
    velocity.add(0,GRAVITY,0); // Velocity is 120 m/s. Add -1 m/s to it (regardless 
                               // of how much time has passed since last frame!) so now 
                               // it is 119 m/s.
velocity.scl(dt); // Scale the velocity by the time passed since last frame, probably 
                  // about 1/60 s, so now the velocity is 119/60 = 1.98 m/s.