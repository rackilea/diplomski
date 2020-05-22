PrintWriter out = null;
try {
      out = new PrintWriter(
                new BufferedWriter(
                new FileWriter(filetest)));
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }