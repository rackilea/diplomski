switch (in.nextInt()) {
    case 1: {
        repeatInt = 1;
        repeatInt2 = 0; // add this line here
        break;
    }
    case 2: {
        repeatInt2 = 1;
        break;
    }
    default: {
        repeatInt = repeatInt2 = 0;
    }
}