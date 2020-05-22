public ShapeGrid(int rows, columns)
{
    setLayout(new GridLayout(rows, columns, 5, 5));   
    int drawShapes = rows * columns;

    for(int i = 0; i < drawShapes; i++) {
        add( new Shape() );
    }
}