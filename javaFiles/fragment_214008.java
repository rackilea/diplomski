class MyData {
    private String text;
    private int number;

    MyData(String text, int number) {
        this.text = text;
        this.number = number;
    }

    public synchronized String getText() {
        return text;
    }

    public synchronized void setText(String text) {
        this.text = text;
    }

    public synchronized int getNumber() {
        return number;
    }

    public synchronized void setNumber(int number) {
        this.number = number;
    }
}

MyData data = new MyData("nodata", 23);