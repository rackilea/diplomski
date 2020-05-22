Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", password);
        Statement stmt = null;

        try {
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SHOW PROCESSLIST");
                while (rs.next())
                {
                    System.out.println(rs.getString("Host"));
                    System.out.println(rs.getString("Id"));
                    System.out.println(rs.getString("User"));
                    System.out.println(rs.getString("db"));
                    System.out.println(rs.getString("Command"));
                    System.out.println(rs.getString("state"));
                    System.out.println(rs.getString("info"));
                }