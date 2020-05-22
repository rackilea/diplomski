ArrayList<String> savedLines = new ArrayList<String>();
    try (BufferedReader lineReader = new BufferedReader(new FileReader(filePath)))
    {
        String lineText = null;

        while ((lineText = lineReader.readLine()) != null) {
            String[] split = lineText.split("\t"); 
            if(split[2].equals("3")||split[2].equals("4")){
                    savedLines.add(lineText);
                    numberOfContracts++;
            }


        }
    } 
    catch (IOException ex)
    {
        System.err.println(ex);
    }