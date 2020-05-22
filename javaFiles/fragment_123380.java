BufferedWriter writer = null;

    try {
        String line;
        Process p = Runtime.getRuntime().exec("ps -A -o pid");
        BufferedReader input =
                new BufferedReader(new InputStreamReader(p.getInputStream()));
        writer = new BufferedWriter(new FileWriter(" the path .."));
        while ((line = input.readLine()) != null) {

              writer.write(line);
            System.out.println(line);

        }
        writer.close();
        input.close();

    } catch (Exception err) {
        err.printStackTrace();
       System.out.println("Sorry!");
    }