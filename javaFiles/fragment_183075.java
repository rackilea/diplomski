LinkedList<DrawingElement> drawing = new LinkedList<DrawingElement>();
DrawingElement circle = new DrawingElement('c', 10, 10, 10, 10);
DrawingElement rect = new DrawingElement('r', 20, 10, 10, 10);
drawing.add(circle);
drawing.add(rect);
int n = drawing.size(); //will be 2