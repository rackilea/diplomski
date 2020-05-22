public void cancel() {
        try {
            bluetoothSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } // Close try
    } // Close cancel()
} // Close ConnectingThread

} // DELETE THIS CURLY BRACE