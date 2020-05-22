pw = new PrintWriter(fw);
try {
  // print to created file
  // pw.println(firstName);
  // pw.println(lastName);
  // pw.println(balance);
  // pw.println(id);
  // pw.println(RATE);
  pw.println(acctException.toString()); // <-- Since 
                    // System.out.println(acctException.toString()); works!
} finally {
  pw.close(); // <-- Always close()!
}