public static void StartBrain() throws IOException {
    System.out.println("socket brain started");
    String BrainMessage = getSocketMessage();
    if (BrainMessage.equals("command")) {
        System.out.println("Command EXECUTED HAHA");
    } else if (BrainMessage.equals("taskschedule")) {
        System.out.println("task scheduled");
    } else {
        System.out.println("no command received");
    }

}