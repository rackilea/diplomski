class MyData {
    private final AtomicReference<String> text;
    private final AtomicInteger number;

    MyData(String text, int number) {
        this.text = new AtomicReference<String>(text);
        this.number = new AtomicInteger(number);
    }

    public String getText() {
        return text.get();
    }

    public void setText(String text) {
        this.text.set(text);
    }

    public int getNumber() {
        return number.get();
    }

    public void setNumber(int number) {
        this.number.set(number);
    }
}