File file = new File("./db.txt");
PrintWriter pw = new PrintWriter(file, true); // true for auto-flush
pw.println("Line 1");
pw.println("Line 2");
pw.println("Line 3");
pw.close();