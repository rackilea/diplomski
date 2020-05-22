public class Server {
    private static boolean running = true;

    public static ArrayList<User> userlist;

    public static synchronized void stop() { //synchronized in-case another thread other than the main thread stops the server
        if(!running) return;
        running = false;
    }

    public static void main(String[] args) {
        /* uses the JVM thread (main thread for applications), so if you dont wanna
        ** dedicate your entire server to accepting connections only (since Users are in new thread)
        ** create a new thread for the code in this void method. */

        try {
            ServerSocket ss = new ServerSocket(8000);

            userlist = new ArrayList<User>();
            User user; //holds the user so we can put it in the list, then start
        while(running) {
            user = new User(ss.accept());

            list.add(user);
            user.start();
        }
        } catch(IOException e) {
            e.printStackTrace(); }
    }
}