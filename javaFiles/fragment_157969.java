class Data implements Printable {
    String message;
    ...
    @Override
    public void print() {
        System.out.println(message);
    }
}