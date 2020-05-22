readSingleValue(transaction, "select * from users where user_id = 1", null, 
        rs -> {
            User u = new User();
            u.setId(rs.getInt(1));
            u.setName(rs.getString(2));
            ...
            return u;
        });