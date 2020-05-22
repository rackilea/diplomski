class Parent{  
    protected int width = 5;
    protected int height = 5;
}

class Child extends Parent{

    public Child(int width, int height){
        this.width = width;
        this.height = height; 
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getSuperHeight() {
        return super.height;
    }

    public int getSuperWidth() {
        return super.width;
    } 
}