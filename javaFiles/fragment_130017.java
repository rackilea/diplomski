for (int i = 0; i < shapes.size() - 1; i++)
{
    Rectangle r1 = shapes.get(i).getBounds();
    Rectangle r2 = shapes.get(i+1).getBounds();

    int x1 = r1.x + r1.width / 2;
    int y1 = r1.y + r1.height / 2;

    int x2 = r2.x + r2.width / 2;
    int y2 = r2.y + r2.height / 2;

    g.drawLine(x1, y1, x2, y2);
}

for(Shape shape : shapes) {