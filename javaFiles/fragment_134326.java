int numberOfDays;
switch (month) {
case 1: // $FALL-THROUGH
case 3: // $FALL-THROUGH
case 5: // $FALL-THROUGH
case 7: // $FALL-THROUGH
case 9: // $FALL-THROUGH
case 11:
    numberOfDays = 31;
    break;
case 4: // $FALL-THROUGH
case 6: // $FALL-THROUGH
case 8: // $FALL-THROUGH
case 10: // $FALL-THROUGH
case 12:
    numberOfDays = 30;
    break;
case 2:
    numberOfDays = (0 == year / 4) ? 29 : 28;
    break;
default:
    throw new IllegalArgumentException("month not 1-12");
} // switch (too long for my liking)