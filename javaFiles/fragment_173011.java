final File input = new File("com/aexp/file.txt");
        List<String> output = new ArrayList<>();
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
             reader = new BufferedReader(new FileReader(input));
            String line;
            while((line = reader.readLine()) != null){
                output.add(line.replaceAll(" ", ","));
            }

            reader.close();

             writer = new BufferedWriter(new FileWriter(new File("output.txt")));
            for (String s : output) {
                writer.write(s);
                writer.newLine();
            }

            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }