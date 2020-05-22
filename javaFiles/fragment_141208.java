for (j = 0, y = 0.0; j < steps; j++, y+=in_steps) {
    beginShape(QUAD_STRIP);

    noStroke(); // no lines

    for (i = 0, x = 0.0; i <= steps; i++, x+=in_steps) {

        fill(255, matrix[i][j] * 255, 0); // interpolate between red and yellow
        vertex(x, y, matrix[i][j]);

        fill(255, matrix[i][j+1] * 255, 0); // interpolate between red and yellow
        vertex(x, y + in_steps, matrix[i][j+1]);
    }
    endShape();
}