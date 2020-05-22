InputStreamReader isr = new InputStreamReader(new FileInputStream("c:\\anyfile"));
        BufferedReader in = new BufferedReader(isr);
        String line = "";
        try {
          while ((line = in.readLine()) != null) {
            System.out.println("line: "+line);
          }
          System.out.println("OUTSIDE !!!");
          in.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }