private static List<IncomingRequestDebugListener> incomingRequestDebugListeners = new ArrayList<>();
private static List<OutgoingRequestDebugListener> outgoingRequestDebugListeners = new ArrayList<>();
private static Boolean enableOutputToConsole;
private static SmackDebugger consoleDebugger;
private ReaderListener readerListener;
private WriterListener writerListener;
private ObservableWriter writer;
private ObservableReader reader;

public SubscribeDebugger(XMPPConnection connection) {
    super(connection);
    if (this.getEnableOutputToConsole()) {
        consoleDebugger = new ConsoleDebugger(connection);
    }
    readerListener = str -> notifyIncomingRequestDebugListeners(str.toString());
    writerListener = str -> notifyOutgoingRequestDebugListeners(str.toString());
}

public Boolean getEnableOutputToConsole() { return enableOutputToConsole; }
public static void setEnableOutputToConsole(Boolean active) {
    enableOutputToConsole = active;
}

/*Static part since a debugger will be initiated by xmpp connection. Smack does not
  provide access on the debugger instances. All instances share the listeners.*/
public static void registerIncomingRequestDebugListener (IncomingRequestDebugListener listener) {
    incomingRequestDebugListeners.add(listener);
}
public static void unregisterIncomingRequestDebugListener(IncomingRequestDebugListener listener) {
    incomingRequestDebugListeners.remove(listener);
}
public static void registerOutgoingRequestDebugListener (OutgoingRequestDebugListener listener) {
    outgoingRequestDebugListeners.add(listener);
}
public static void unregisterOutgoingRequestDebugListener(OutgoingRequestDebugListener listener) {
    outgoingRequestDebugListeners.remove(listener);
}
protected void notifyIncomingRequestDebugListeners (String streamElement) {
    incomingRequestDebugListeners.parallelStream().forEach((listener) -> {
        listener.onRequestReceived(streamElement);
    });
}
protected void notifyOutgoingRequestDebugListeners (String streamElement) {
    outgoingRequestDebugListeners.parallelStream().forEach((listener) -> {
        listener.onRequestSent(streamElement);
    });
}

@Override
public void userHasLogged(EntityFullJid user) {

}

@Override
public Reader newConnectionReader(Reader reader) {


    ObservableReader debugReader = new ObservableReader(reader);
    debugReader.addReaderListener(readerListener);
    reader = debugReader;

    if (enableOutputToConsole && consoleDebugger != null)
        return consoleDebugger.newConnectionReader(reader);
    return reader;
}

@Override
public Writer newConnectionWriter(Writer writer) {
    if(enableOutputToConsole && consoleDebugger != null)
        return consoleDebugger.newConnectionWriter(writer);
    return writer;
}

@Override
public void onIncomingStreamElement(TopLevelStreamElement streamElement) {
    if(enableOutputToConsole && consoleDebugger != null)
        consoleDebugger.onIncomingStreamElement(streamElement);


}

@Override
public void onOutgoingStreamElement(TopLevelStreamElement streamElement) {
    if (enableOutputToConsole && consoleDebugger != null)
        consoleDebugger.onOutgoingStreamElement(streamElement);

}