Vector2f rv = Vector2f.sub(bV, aV);
    Vector2f norm = Vector2f.sub(bPos, aPos);
    float velAlongNormal = CMath.dot(rv, norm);

    // Do not resolve if velocities are separating
    if(velAlongNormal > 0) {
        return;
    }