interface PrintText {
    void printText();
}

class Food implements PrintText {
    public void printText() {
       System.out.println("Food is in the way.");
    }
}

class SomeObject implements PrintText {
    public void printText() {
       System.out.println("Object is in the way.");
    }
}