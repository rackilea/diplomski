private void putMessage() throws InterruptedException {
    synchronized (messages) { // <======
        while (messages.size() == MAXQUEUE) {
            messages.wait();  // <======
        }
        messages.addElement(new java.util.Date().toString());
        System.out.println("put message");
        messages.notifyAll(); // <======
    }
}

public String getMessage() throws InterruptedException {
    synchronized (messages) { // <======
        while (messages.size() == 0) {
            messages.wait();  // <======
        }
        String message = (String) messages.firstElement();
        messages.removeElement(message);
        messages.notifyAll(); // <======
        return message;
    }
}