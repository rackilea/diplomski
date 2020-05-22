OUTER: while(true) switch(tested) {
    case GOOD:
        // something
        break;
    case ALSO_GOOD:
        // something
        break;
    default:
        break OUTER;
}