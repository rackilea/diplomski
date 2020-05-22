size(200,200);
background(255);
float w = 60;
float radius = 20;
while ( radius <= 200) {
    stroke(0);
    fill( w, w );
    ellipse(100, 100, radius, radius);
    radius += 20;
}