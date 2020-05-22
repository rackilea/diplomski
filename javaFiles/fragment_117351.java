Boolean player1_up = false;
Boolean player1_down = false;
Boolean player2_up = false;
Boolean player2_down = false;

void keyPressed() {
    if (keyCode == UP)
        player1_up = true;
    else if (keyCode == DOWN)
        player1_up = true;
    if (key == 'w' || key == 'W')
        player2_up = true;
    else if (key == 's' || key == 'S')
        player2_down = true;
}

void keyReleasd() {
    if (keyCode == UP)
        player1_up = false;
    else if (keyCode == DOWN)
        player1_up = false;
    if (key == 'w' || key == 'W')
        player2_up = false;
    else if (key == 's' || key == 'S')
        player2_down = false;
}