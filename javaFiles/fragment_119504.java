try {
    BufferedReader loadReader = new BufferedReader(new FileReader("GamesList.txt"));
    String loadText = "";
    int consoleIndex = -1; // for storing the console index
    while((loadText = loadReader.readLine()) != null) {
        // getting the index of loadText from consoleList.
        // store your consoles name in uppercase in consoleList.
        int index = consolesList.indexOf(loadText.toUpperCase()); // 
        if(index != -1){ // if console name is present in loadText
            consoleIndex = index;
            continue;
        }
        // put game in respected console.
        consolesList.get(consoleIndex).gamesList.add(loadText);
    }
} catch (Exception e) {
    System.out.println("This did nothing");
}