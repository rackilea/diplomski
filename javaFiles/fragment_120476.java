private LinkedList<XMPPmessageListener> listeners = new LinkedList<XMPPmessageListener>();

public void addMsgListener(XMPPmessageListener listener){
    listeners.add(listener);
}

public boolean removeMsgListener(XMPPmessageListener listener){
    return listeners.remove(listener);
}