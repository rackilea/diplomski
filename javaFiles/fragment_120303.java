int minX = Integer.MAX_VALUE;
int maxX = Integer.MIN_VALUE;

int minY = Integer.MAX_VALUE;
int maxY = Integer.MIN_VALUE;

for (A a: collection) {
    if (a.x < minX)
       minX = a.x;
    if (a.x > maxX)
       maxX = a.x;

    if (a.y < minY)
       minY = a.y;
    if (a.y > maxY)
       maxY = a.y;

}