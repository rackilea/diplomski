Graphics2D g2d = (Graphics2D)g.create();

for (Shape shape : shapes)
{
    g2d.draw( shape );
}

g2d.dispose();