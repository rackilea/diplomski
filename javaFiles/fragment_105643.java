Connection conn = null;
try {
   // initialize connection
   // use connection 
} catch {
  // handle exception
} finally {
  if (conn != null) {
     try { conn.close(); } catch (Exception e) { /* handle close exception, quite usually ignore */ } 
     }
}