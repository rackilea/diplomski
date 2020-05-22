if ((position0 == (3 * position2)) && // note that position0 is the "thousands place", not position3
    ((position0+position1+position2+position3) == 27) && // sum of digits
    (position3 % 2 == 1) && // odd number
    (position0 != position1 && position0 != position2 && position0 != position3  &&
     position1 != position2 && position1 != position3 && position2 != position3)) { // different digits
    found = true;
}