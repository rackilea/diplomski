public RedBlueExtravaganza(Toy rt, Toy bt) {
    if (!(rt instanceof RedToy) || !(bt instanceof BlueToy))
        throw new IllegalArgumentException();

    // remainder omitted.
}