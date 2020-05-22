// establish connection to database                              
            conn = DriverManager.getConnection(DATABASE_URL, "jonh86", "ADMIN");
            if(conn == null) System.out.println("Could not Connect");
            System.out.println("Connected...."); //--this code is misleading
            ps = conn.prepareStatement("select * from userdata where user_name = ? and password = ?");
            ps.setString(1, uname);
            ps.setString(2, passwd);
            rs = ps.executeQuery();