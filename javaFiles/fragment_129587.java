switch(monthNum) {
    case 1:
    case 3:
    // ...
    case 12:
        return dayNum <= 31;
    // similarly for the other months
    // ...
    case default:
        // should probably do something about invalid monthNum
}