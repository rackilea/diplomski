switch(n) {
    case 1: this.max = 100;
            break;
    case 2: this.max = 150;
            break;
    case 3: this.max = 200;
            break;
    default: throw new IllegalArgumentException("Not 1, 2 or 3");
}