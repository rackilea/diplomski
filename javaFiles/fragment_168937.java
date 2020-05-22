// generated class
class MyTypeGen  {      
    int x, y;

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}

// introduce two new methods into MyTypeGen
aspect MyTypeAspect {
    public int MyTypeGen.multiply() {
        return x * y;
    }
    public int MyTypeGen.sum() {
        return x + y;
    }
}