ColorShape[][] grid = new ColorShape[width][height];
TetrisShape shape = new TetrisShape(Shape.L_SHAPE);

//position will be bottom left coordinate of bounding rectangle of dropping shape.
Point position = new Point(shape.getPosition());
int resultY = -1;
for(int dy=0;dy<height;dy++){
    for(int y=0;y<height;y++){
        int shapeY = position.y+y;
        if(shapeY>=height || shape.intersectsGrid(grid)){
            resultY = shapeY -1;
            break;
        }        
    }
}