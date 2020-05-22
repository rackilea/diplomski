File file = new File("./db.txt");
FileWriter fw = new FileWriter(file, true); // true for appending
PrintWriter pw = new PrintWriter(fw, true); // true for auto-flush
pw.println("Line 4");
pw.println("Line 5");
pw.println("Line 6");
pw.close();