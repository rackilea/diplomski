g.setColor(Color.red);
    g.fillOval(x_pos - radius, y_pos - radius, 2 * radius, 2 * radius);

    screen.drawImage(buffer,0,0,this);

    g.setColor(Color.green);
    g.fillOval(x_pos - radius, y_pos - radius, 2 * radius, 2 * radius);