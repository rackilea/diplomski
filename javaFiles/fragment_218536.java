void keyPressed() {
    if (keyCode == DOWN)
        steps /= 2.0;
    else if (keyCode == UP)
        steps *= 2.0;
}