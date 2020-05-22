public static void main(String[] args) {
    Cell cell = new Cell();
    Var<Number> size = Val.selectVar(cell.shapeProperty(), Shape::sizeProperty);
    size.addListener(
            (obs, oldSize, newSize) -> System.out.println("Size changed from "+oldSize+" to "+newSize));

    cell.getShape().setSize(10);
    cell.setShape(new Shape());
    Shape s = new Shape();
    s.setSize(20);
    cell.setShape(s);
}