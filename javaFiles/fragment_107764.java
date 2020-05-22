switch (gender) {
    case 'm':
        temp = 0;
        switch (children) {
            case 0:
            case 1:
            case 2:
            case 3:
                temp += 2;
                break;  
            default:
                temp += 1;
        }
        break;
    case 'f':
        temp = 2;
        switch (children) {
            case 0:
            case 1:
            case 2:
            case 3:
                temp += 1;
                break;
            default:
                temp += 2;
        }
        break;
}