int count = rs.getRow();
        b = new Book();
        t = new Type();
        b.setName(rs.getString("name"));
        t.setTypename(rs.getString("typename"));
        b.setType(t);
        list.add(b);