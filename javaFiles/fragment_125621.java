if (ball_x == 300 && ball_y > paddle_y && ball_y < paddle_y + 100) {

    score += 10;

    ball_dx *= -1;
    ball_x += (2 * ball_dx);
    ball_dy *= -1;
    ball_y += (2 * ball_dy);

}