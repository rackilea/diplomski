Stream<Cell> streamCellsTouchingRay(Point2D fromPoint, Vector2D direction){
    // ...
    Stream.Builder<Cell> cells = Stream.builder();
    cells.add(/* 1st item */);
    while(/* ... */){
        // ...
        cells.add(/* i'th item */);
    }
    return cells.build();
}