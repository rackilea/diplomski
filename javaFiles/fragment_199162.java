Writer w = new FileWriter(name, true);
PrintWriter pw = new PrintWriter(w);
....
pw.flush();
pw.close();
w.flush();
w.close();