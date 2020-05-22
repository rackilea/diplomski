public static void main(String args[]) {
    // Create three concurrent threads
    new Thread(new Multithreading()).start();
    new Thread(new Multithreading()).start();
    new Thread(new Multithreading()).start();

    for(String s : infiList)
        System.out.println(s);
}