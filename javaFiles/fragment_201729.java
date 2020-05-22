public DataConnection() {
            try {
                InitialContext ctx = new InitialContext();
                dataSource = (DataSource)ctx.lookup(dataSource name);
            } catch (NamingException e) {
                    e.printStackTrace();
            }
        }