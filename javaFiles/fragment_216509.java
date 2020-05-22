{
Random gen = new Random();
int x = 0;
int y = 0;
int radius = 0;
double largestRadius = Math.max(radius);
Circle largestCircle = null;
Group root = new Group();
//prints out 30 circles
for (int i = 0; i <= 30; i++)
{
    Circle circle = new Circle(x, y, radius);

    if (circle.getRadius() > largestRadius)
    {
        largestCircle = circle;
    }

    {
        radius = gen.nextInt(66) + 10; //generates random radius from 10 to 75
        x = gen.nextInt(600 - 2 * radius) + radius;
        y = gen.nextInt(400 - 2 * radius) + radius;
    }

    circle.setFill(null);
    circle.setStroke(Color.rgb(gen.nextInt(256), + gen.nextInt(256), gen.nextInt(256)));
    circle.setStrokeWidth(3);
    root.getChildren().add(circle);
}
largestCircle.setFill(Color.rgb(255, 0, 0, 0.3));