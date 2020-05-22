class Blob {
    float x, y;
    float size;

    Blob(float tempX, float tempY, int size) {
        this.x = tempX;
        this.y = tempY;
        this.size = size;
    }

    void display() {
        ellipse(x, y, size, size);
    }


    void dragging() {
        if (dist(x, y, mouseX, mouseY) < myBlob.getSize()/2) {
            myBlob.setBlobSize(25);
            this.x = random(displayWidth/2);
            this.y = random(displayHeight/2);
        }
    }

    void setX(float x){
      this.x = x;
    }

    void setY(float y) {
      this.y = y;
    }

    void setBlobSize(float size) {
       this.size += size; 
    }

    float getSize() {
      return this.size;
    }

}