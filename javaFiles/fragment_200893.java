class Application {

    public static void main(String[] args) {
        final Chat chat = new Chat();

        chat.registerUser(new User("user1", chat));
        chat.registerUser(new User("user2", chat));
        chat.registerUser(new User("user3", chat));
    }

}

class Chat {

    private final Scanner scanner = new Scanner(System.in);
    private final List<User> users = new ArrayList<>();

    private void registerUser(User user) {
        users.add(user);
        System.out.format("'%s' connected to the chat.\n", user);
        user.start();
    }

    public void sendMessage(User user) {
        final String reply = scanner.nextLine();
        System.out.format("%s: %s\n", user, reply);

        if (reply.equalsIgnoreCase("bye")) {
            users.forEach(Thread::interrupt);
            System.out.println("The chat is over.");
        } else {
            notifyAll();
        }
    }

}

class User extends Thread {

    private final String id;
    private final Chat chat;

    public User(String id, Chat chat) {
        this.id = id;
        this.chat = chat;
    }

    public void run() {
        while (true) {
            try {
                synchronized (chat) {
                    chat.sendMessage(this);
                    chat.wait();
                }
            } catch (InterruptedException e) {
                throw new IllegalArgumentException("Someone left. I am done as well.");
            }
        }
    }

    @Override
    public String toString() {
        return id;
    }

}