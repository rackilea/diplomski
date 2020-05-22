class Rocket
{
    boolean started = false;

    // [...]


    void setY(int newY) {
        this.y = newY;
        started = true;
    }

    void mouseClicked() {

        if (started) {
            this.x = x+5;
        }
    }
}