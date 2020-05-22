class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Thread.currentThread()
            .getContextClassLoader().loadClass(ContextClosedEvent.class.getName());
    }
}