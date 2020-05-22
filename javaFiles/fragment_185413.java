class MyException extends Exception{
    String message;

    public MyException(String string) {
        this.message = string;
    }

    @Override
    public String toString() {
        String s = getClass().getCanonicalName();
        String message = this.message;
        return (message != null) ? (s + ": " + message) : s;
    }
}