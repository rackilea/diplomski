Server server = null;
            try {
                server = Server.createTcpServer("-tcpAllowOthers").start();
                Class.forName("org.h2.Driver");
                Connection conn = DriverManager.
                    getConnection("jdbc:h2:tcp://localhost/~/stackoverflow", "sa", "");
                System.out.println("Connection Established: "
                        + conn.getMetaData().getDatabaseProductName() + "/" + conn.getCatalog());

            } catch (Exception e) {
                e.printStackTrace();