int count = rs.getRow();
        b = new Book();
        t = new Type();
        b.setName(rs.getString("name"));
        t.setTypename(rs.getString("typename"));
        list.add(b);