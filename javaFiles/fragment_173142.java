package events;

public class Shape {

int x1;
int x2;
int y1;
int y2;
int width;
int height;
static Shape one = new Shape(4,4,4,4);

Shape(int x1, int y1, int width, int height) {

    this.x1 = x1;
    this.y1 = y1;
    this.width = width;
    this.height = height;
    this.x2 = x1 + width;
    this.y2 = y1 + height;

}

public static void main(String[] args){


    int x = one.x1;

}

}