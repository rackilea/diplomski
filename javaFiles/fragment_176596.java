ovals = new MyOval[ 5 + randomNumbers.nextInt(5)];
rectangles = new MyRectangle [ 5 + randomNumbers.nextInt(5)];

for (int count = 0; count <ovals.length; count++){
    int x1 = randomNumbers.nextInt(300);
    int y1 = randomNumbers.nextInt(300);
    int x2 = randomNumbers.nextInt(300);
    int y2 = randomNumbers.nextInt(300);

    Color color = new Color (randomNumbers.nextInt(256), randomNumbers.nextInt(256), randomNumbers.nextInt(256));

    ovals[count] = new MyOval(x1, y1, x2, y2, color);
    rectangles[count] = new MyRectangle(x1, y1, x2, y2, color);
}