new Thread() {
@Override public void run() {
try {    
Runtime.getRuntime().exec("cmd.exe /c start " + Gui._batFile);
} catch (IOException e1) {
e1.printStackTrace();
}
}
}.run();