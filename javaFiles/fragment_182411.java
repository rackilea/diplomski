private static class MariaDbDExtender extends MariaDbDataSource {

        private String password;

        public MariaDbDExtender(String connectionUrl) throws SQLException {
            super(connectionUrl);
        }


        @Override
        public void setPassword(String pass) {
            this.password = pass;
            super.setPassword(pass);
        }

        //this method is required to allow c3p0 magically use reflection to get correct password for connection
        public String getPassword() {
            return password;
        }
    }