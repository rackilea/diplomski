@Override
    public void close() {
        if (pendingItems > 0) {
            sendData();
        }
    }