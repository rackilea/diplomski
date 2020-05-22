public static void main(String[] argv) {

    long lStartTime = new Date().getTime(); // start time

    createArray(); // some tasks to eat time

    long lEndTime = new Date().getTime(); // end time

    long difference = lEndTime - lStartTime; // check different

    System.out.println("Elapsed milliseconds: " + difference);

}

public static void createArray() {

    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    String sArray[] = new String[1000000];

    for (int i = 0; i < 1000000; i++)
        sArray[i] = "Array " + i;

}