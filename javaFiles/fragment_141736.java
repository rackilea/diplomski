pool = appContext.getBean("connectionPool");
conn = pool.get();
try {
  // .. do stuff
} finally {
  conn.close();
  // or
  pool.release(conn);
}