byte[] pdfData = null;
ResultSet rset = pstmt.executeQuery();
if (rset.next())
{
  pdfData = rset.getBytes(1);
}
conn.close();
return pdfData;