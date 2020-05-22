try {
    for (int i = 0; i < maxClientsCount; i++) {
        long startTime = System.currentTimeMillis();
        if (threads[i] != null && threads[i] == this) {
            while ((System.currentTimeMillis() - startTime) < 1000) {
                if (threads[i].is.read() == -1) {
                    MyClientSocket.input("");
                }
            }
        }                   
    }
} catch (Exception e) {
    break;
}