int closestSquare = 0;
for (closestSquare = 0; closestSquare <= iPart; closestSquare++) {
     if (closestSquare * closestSquare > iPart) {
          closestSquare -= 1;
          break;
     }
}