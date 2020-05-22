try (Scanner in = new Scanner(new FileInputStream(file.getPath()));
          PrintWriter out = new PrintWriter(new FileOutputStream("S2.gr")))
     {
        createS2(in, out);
     } catch (Exception e) {
        System.out.println("There was an error trying to open the files: " + e.getMessage());
     }