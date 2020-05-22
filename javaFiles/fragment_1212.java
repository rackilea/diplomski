public void disconnect() {
    if(running) {
        running = false;
        try {
            try{
                // had to add this
                conn.getOutputStream().close();
            }
            catch(Exception exc){
            }
            // close the socket
            if(inputStream != null) {
                inputStream.close();
            }
            if(conn != null) {
                conn.disconnect();
            }
            inputStream = null;


        } catch(Exception ignored) {
            main.reportErrorFromThrowable(ignored);
        }
    }
}