if (charY > platTwoY - 15) {
       charX < platTwoX + platTwoW &&
       charX + charW > platTwoX &&
       charY < platTwoY + platTwoH &&
       charH + charY > platTwoY) {
           charY = platTwoY + platTwoH + 1;
           charVY = 0;
           numOfJumps = maxJumps;
           wallCollision = true;
}