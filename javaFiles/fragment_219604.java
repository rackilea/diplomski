float playeryaw = passenger.yaw; //The user

//put playeryaw in the neighborhood of car.yaw
while(car.yaw - playeryaw > 180)
    playeryaw += 360;
while(car.yaw - playeryaw < -180)
    playeryaw -= 360;

float right = car.yaw + 60;
float left = car.yaw - 60;

if (playeryaw < left) {
    playeryaw = left; 
} else if (playeryaw > right) {
    playeryaw = right;
}

//put playeryaw in the desired range
while(playeryaw < 0)
    playeryaw += 360;
while(playeryaw > 360)
    playeryaw -= 360;