connection.setAutocommit(false);
try(PreparedStatement ps = 
            connection.prepareStatement("insert into r_sqlite (NAME, AGE, COMPANY-NAME) VALUES(?,?,?)")) {
      Iterator<dbData> it = dataList.listIterator();
      int batchCount = 0;
      while(it.hasNext()) {
        dbData data = it.next();
        ps.setString(1,  data.getName());
        ps.setInt(2,  data.getAge());
        ps.setString(3,  data.getCompany());
        ps.addBatch();
        if(++batchCount % 1000 == 0) {
            ps.executeBatch();
            ps.clearBatch(); 
        }
      }
      ps.executeBatch();
      connection.commit();
    }