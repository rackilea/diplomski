public void update(float dt)
    {
        if(position.y > 50)
            velocity.add(0, GRAVITY * dt, 0);
        position.add(0, velocity.y * dt, 0);
        if(position.y <= 50)
            position.y = 50;
    }