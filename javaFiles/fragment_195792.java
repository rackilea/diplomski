try {
        String outputFile1 = "pokedex1.csv";
        FileWriter fileWriter = new FileWriter(prefix+outputFile1, true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for(String pokemon : pokedex1.toString().split("\n")) {
            System.out.println(pokemon);
            bw.write(pokemon);
        }
        bw.flush();
        bw.close();
   } catch (IOException e) {
        System.out.println("\nError writing to Pokedex1.csv!");
        e.printStackTrace();
   }