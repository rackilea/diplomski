class IncomingHandler extends Handler {
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case MSG_REGISTER_CLIENT:
                mClients.add(msg.replyTo);
                break;
            case MSG_UNREGISTER_CLIENT:
                mClients.remove(msg.replyTo);
                break;
            case MSG_SET_VALUE:
                mValue = msg.arg1;
                for (int i=mClients.size()-1; i>=0; i--) {
                    try {
                        mClients.get(i).send(Message.obtain(null,
                                MSG_SET_VALUE, mValue, 0));
                    } catch (RemoteException e) {
                        // The client is dead.  Remove it from the list;
                        // we are going through the list from back to front
                        // so this is safe to do inside the loop.
                        mClients.remove(i);
                    }
                }
                break;
            default:
                super.handleMessage(msg);
        }
    }
}