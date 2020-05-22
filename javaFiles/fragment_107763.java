switch (gender) {
    case 'm':
        temp = 0;
        if (children >= 4) {
            temp += 1;
        } else {
            temp += 2;
        }
        break;
    case 'f':
        temp = 2;
        if (children >= 4) {
            temp += 2;
        } else {
            temp += 1;
        }
        break;
}