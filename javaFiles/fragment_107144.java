public static interface IConnection {
    char get(int index);

    void set(int index, char c);

    int length();
}

public static class Database {
    private char[] tab = new char[100];

    public static IConnection getConnection() {
        return Connection.getInstance();
    }

    private static final class Connection implements IConnection {
        private Database db;
        private Connection() {
            super();
        }
        private static IConnection[] instance = new IConnection[3];
        static {
            for (int i = 0; i < instance.length; i++) {
                instance[i] = new Connection();
            }
        }
        private static int i = 0;
        public static IConnection getInstance() {
            return instance[(i++)%instance.length];
        }

        public char get(int index) {
            return db.tab[index];
        }

        public void set(int index, char c) {
            db.tab[index] = c;
        }

        public int length() {
            return db.tab.length;
        }
    }
}
public static void main(String[] args) {
    IConnection conn1 = Database.getConnection();
    IConnection conn2 = Database.getConnection();
    IConnection conn3 = Database.getConnection();
    IConnection conn4 = Database.getConnection();
    if (conn1 == conn4) {
        System.out.println("conn1 has the same reference as conn4");
        if (conn1 != conn2 && conn1 != conn3 && conn2 != conn3) {
            System.out.println("conn1 != conn2 AND conn1 != conn3 AND conn2 != conn3");
            System.out.println("Quod erat demonstrandum");
        }
    }
}