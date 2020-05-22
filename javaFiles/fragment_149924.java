void writeToFile(String input) throws IOException{
            File file = new File("C:\\WeatherExports\\export.txt");
            if (!file.getParentFile().mkdirs())
                    throw new IOException("Unable to create " + file.getParentFile());
            BufferedWriter out = new BufferedWriter(new FileWriter(file,true));
            try{
                    out.append(input);
                    out.newLine();
            } finally {
                    out.close();
            } 
    }