public static Square squareFor(int type) {
    switch(type) {
        case 'o': return new SquareOne();
        case 't': return new SquareTwo();
        case 'r': return new SquareThree();
        default: throw new IllegalArgumentException("type "+(char)type);
    }
}