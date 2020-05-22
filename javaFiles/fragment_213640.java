MyNDK myNDK = new MyNDK();
String[] arguments = new String[]{"1", "2", "3"};

myNDK.compresion(arguments);
…
public native void compresion(String[] argv);