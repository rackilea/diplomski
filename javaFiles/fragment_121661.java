br = new BufferedReader(new FileReader("G:\\lecturer.txt"));
        String line = null;

        while ( (line=br.readLine()) != null){
            records.add(line);
        }