File f = new File(strFileGenLoc);
  BufferedWriter bw = new BufferedWriter(new FileWriter(f, false));
  rs = stmt.executeQuery("select * from jpdata");
  while ( rs.next() ) {
    bw.write(rs.getString(1)==null? "":rs.getString(1));
    bw.write("\\r\\n");
  }