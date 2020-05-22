String rm = tf_rm_id.getText();
rm = rm == null || rm.isEmpty() ? 0 : rm ; // consider 0 is valid here
long value ;
try {
  value = Long.parseLong(rm) ;
  stmt.setLong(1, value);
} catch(NumberFormatException  ee) {
  System.out.println("Praser exception, invalid input");
}