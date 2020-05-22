@Override
public int getX() {
    return x;
}

public int getLength() {
    return length;
}

void move(boolean b, int distance) {
    if (b == true) {
        x++;
        a = speed;
        x = x + a;
    }
    else {
        if (x > 300) {
            x++;
            a = speed;
            x = x + a;
        }
        else if (x < (250 - distance)) {
            x++;
            a = speed;
            x = x + a;
        }
    }
}