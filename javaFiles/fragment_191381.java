conn.setAutoCommit(false);
for(int bi : bSet){
    pb.setLong(1,aID);
    pb.setInt(2,bi);
    pb.executeUpdate();
    }
conn.commit();
conn.setAutoCommit(true);