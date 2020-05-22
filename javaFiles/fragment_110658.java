PrintWriter out;
try {
     out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(penFileOutput(filename, Context.MODE_PRIVATE))));
     out.println(balanceString);
     out.flush();
     out.close();
    }
catch (Exception e) {
     e.printStackTrace();
     System.out.println("Error in Writing File.");
    }