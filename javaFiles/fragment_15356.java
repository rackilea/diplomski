Scanner in = null;
    PrintWriter out = null;
    try {
        in = new Scanner(new FileInputStream(file.getPath()));
        out = new PrintWriter(new FileOutputStream("S2.gr"));
        createS2(in, out);
    } catch (Exception e) {
        System.out.println("There was an error trying to open the files: " + e.getMessage());
    }
    finally {
        if(in != null) in.close();
        if(out != null) out.close();
    }