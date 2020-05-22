final int DIFF_SIZE = 1;
final int MIN_SIZE = 6;
final int MAX_SIZE = 40;

final float INIT_RED = 100, INIT_GREEN = 50, INIT_BLUE = 80;
final float FINAL_RED = 255, FINAL_GREEN = 200, FINAL_BLUE = 250;

class Rectangle {

    int pos_x, pos_y, size;
    color col;

    Rectangle(int px, int py, int s, color c) {
        col = c;
        pos_x = px; pos_y = py;
        size = s;
    }

    void Update(int px, int py, int inc_size) {
        pos_x = px; pos_y = py;

        size += inc_size;
        if (size > MAX_SIZE)
            size = MIN_SIZE;

        float w = float(size - MIN_SIZE) / float(MAX_SIZE - MIN_SIZE);
        float redValue   = INIT_RED   + w * (FINAL_RED - INIT_RED);
        float greenValue = INIT_GREEN + w * (FINAL_GREEN - INIT_GREEN);
        float blueValue  = INIT_BLUE  + w * (FINAL_BLUE - INIT_BLUE);
        col = color(int(redValue), int(greenValue), int(blueValue));
    }

    void Draw() {
        fill(col);
        rect(pos_x-size/2, pos_y-size/2, size, size);
    }
}