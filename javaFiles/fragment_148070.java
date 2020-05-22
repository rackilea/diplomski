@Override
public void stop() throws Exception {
    System.out.println("STOP");
    Platform.exit();
    System.exit(0);
}