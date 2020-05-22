class MessEverythingUp {
    public MessEverythingUp(Foo foo) {
        synchronized (foo) {
            while (true) {
                System.out.println("Pwnd ur thread safety");
            }
        }
    }
}