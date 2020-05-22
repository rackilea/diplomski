try {
    BufferedReader br = new BufferedReader(new FileReader(file));
    int remainingLines = 0;
    String stringYouAreLookingFor = "";
    for(String line; (line = br.readLine()) != null; ) {
        if (line.startsWith("Intent")) {
            remainingLines = <Number of Lines you want to read after keyword>;
            stringYouAreLookingFor += line
        } else if (remainingLines > 0) {
            remainingLines--;
            stringYouAreLookingFor += line
        }    
    }
}