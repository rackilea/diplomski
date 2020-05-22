MyBlob blob = ....;
 PreparedStatement ps = ....;
 ps.setByte(1, blob.getMyBlobField());

 ps.execute();
 //Handle Exceptions...close...etc.