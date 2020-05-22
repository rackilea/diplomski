@Override
public void run() {
    try {
        doPrintTaskStuff();
    } catch (Throwable t) {
        sendEmailAboutException(t);
    }
}