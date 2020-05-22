public static void main(String[] args) {
        try {
            mergeMigrations(args[0], args[1]);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }