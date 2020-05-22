int currentLine = 0;
while (lineScanner.hasNext()) {
    if (currentLine < tvShow.length) {
        tvName = lineScanner.next();
        genre = lineScanner.next();
        network = lineScanner.next();
        runningTime = lineScanner.nextInt();
        favorite = lineScanner.next();

        tvShow[currentLine] = new TVShow(tvName, genre, network, runningTime,
                               favorite);
        currentLine++;
    } else {
        System.err.println("The array is full");
        break;
    }

}