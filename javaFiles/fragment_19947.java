BufferedReader reader;
    HashMap<String,Double> vars = new HashMap<>();
    try {
        reader = new BufferedReader(new FileReader(
                "src/Data.txt"));
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            String[] lineVars = line.split(" ");
            vars.put(lineVars[0],Double.parseDouble(lineVars[1]));
            // read next line
            line = reader.readLine();

        }
        reader.close();
    }catch (IOException e) {
        e.printStackTrace();
    }