br = new BufferedReader(new FileReader("G:\\lecturer.txt"));
        String line = br.readLine();

        while ( (line=br.readLine()) != null){
            records.add(line);
        }