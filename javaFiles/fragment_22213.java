synchronized (myList) {
    try {
        while (myList.size() == 0) {
            myList.wait();
        }
        Object elem = myList.removeLast();
    } catch (Exception e) {
        e.printStackTrace();
    }
}