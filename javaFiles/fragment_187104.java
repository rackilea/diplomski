class Player {
    // [...]

    void move() {
        if (!move_up && !move_down) {speedY *= 0.95;}
        if (move_up)                {speedY -= 0.1;}
        if (move_down)              {speedY += 0.1;}
        speedY = max(-5.0, min(5.0, speedY));
        y += speedY;
    }

    // [...]
}