String query = ""
                + "from User where "
                + "u.firstName like '%" + firstName+ "%' ";
        if (!"".equals(lastName)) {
            query += "and u.lastName like '%" + lastName + "%' ";
        }
        if (!"".equals(bDate)) {
            query += "and u.bDate like '%" + bDate + "%'";
        }
        List<User> resultList = null;
        resultList = hibernateTemplate.find(query);