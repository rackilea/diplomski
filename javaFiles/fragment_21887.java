// take the result of the query
ResultSet rs = su.executeQuery(query);
while(rs.next()) { // for each row
   // take the blob
   Blob blob = rs.getBlob(index);
   BufferedInputStream is = new BufferedInputStream(blob.getBinaryStream());
   FileOutputStream fos = new FileOutputStream(file);
   // you can set the size of the buffer
   byte[] buffer = new byte[2048];
   int r = 0;
   while((r = is.read(buffer))!=-1) {
      fos.write(buffer, 0, r);
   }
   fos.flush();
   fos.close();
   is.close();
   blob.free();
}
su.close();