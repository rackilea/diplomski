List<String> singleMaze = new ArrayList<>();
while(file.hasNextLine()) {
    // ...
    if(nextLine.length() == 0) {
        mazegenerator.add(singleMaze);
        singleMaze = new ArrayList<>();
    }
}