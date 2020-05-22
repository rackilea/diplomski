public void detectCollisions() {
    for (int i = 0; i < circles.length; i++)
        for (int j = 0; j < circles.length; j++)
            if (i != j && circles[i].detectCollision(circles[j]))
                circles[i].bounce(circles[j]);
}