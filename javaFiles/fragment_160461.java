color WHITE = color(255);
color BLACK = color(0);

ArrayList<PVector> points = new ArrayList<PVector>();

void setup() {
    size(500, 500);

    int n = 10;
    int radius = 100;
    for (int i = 0; i <= n; i++) {
        float angle = TWO_PI * (float)i/n;
        points.add(new PVector(cos(angle)*radius, sin(angle)*radius));
    }
}

void draw() {
    background(WHITE);
    translate(width/2, height/2);

    noFill();
    stroke(255, 0, 0);

    beginShape();
    PVector last = points.get(points.size()-1);
    curveVertex(last.x, last.y);
    for (int i = 0; i < points.size(); i++) {
        PVector p = points.get(i);
        curveVertex(p.x, p.y);
    }
    PVector first = points.get(0);
    curveVertex(first.x, first.y);
    endShape();
}