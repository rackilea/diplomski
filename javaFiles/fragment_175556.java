private static class MyDAOHolder { 
            public static final MyDAO INSTANCE = new MyDAO();
    }

    public static MyDAO getInstance() {
            return MyDAOHolder.INSTANCE;
    }