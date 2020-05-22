while (rs.next()) {
        String testname = rs.getString("tname");
        String testfee = rs.getString("tfee");
        regForm beanObject = new regForm();
        beanObject.setTname(testname);
        beanObject.setTfee(testfee);
        myBeans.add(beanObject);
    }