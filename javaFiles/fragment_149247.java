private DatagramSocket mSocket;

@Override
public void run() {
    Exception ex = null;
    try {
        // read while not interrupted
        while (!interrupted()) {
            ....
            mSocket.receive(...); // excepts when interrupted
        }
    } catch (Exception e) {
        if (interrupted())
            // the user did it
        else
            ex = e;
    } finally {
        // always release
        release();

        // rethrow the exception if we need to
        if (ex != null)
            throw ex;
    }
}

public void release() {
    // causes exception if in middle of rcv 
    if (mSocket != null) {
        mSocket.close();
        mSocket = null;
    }
}

@Override
public void interrupt() {
    super.interrupt();
    release();
}