private void whileConnected() {
    try {
        mWriter = this.output;
        do {
            input.ready();

            String line;
            while((line = input.readLine()) != null) {
                if(line.length() > 0) {
                    mHandler.post(new updateStatusThread("Arduino: " + line, false));
                    break;
                }
            }

        } while (!message.equals("END"));
    } catch (Exception e) {
        e.printStackTrace();
    }
}