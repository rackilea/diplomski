public StringBuffer answer = new StringBuffer();

public synchronized String getAnswer() {
        synchronized(answer) {
            String returnValue = answer.toString();
            answer.setLength(0); // clear the buffer.
            return returnValue;
        }
}