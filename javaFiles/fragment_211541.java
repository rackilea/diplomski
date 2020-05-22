void draw() {
    fill(0,0,0);
    if (mousePressed == true && mouseY >= 90 && mouseY <= 190 && mouseX >= 440 && mouseX <= 540) {
        fill(255,0,0);
        ellipse(490, 140, 100, 100);
        fill(0,0,0);
    } else {
        ellipse(490, 140, 100, 100);
    }

    ellipse(490, 400, 100, 100);
}