if (searchWord.equalsIgnoreCase("all names")) {
    for(String temp: list) {
        System.out.println(temp);
    }
} else if (line.toLowerCase().contains(searchWord.toLowerCase())) {
        System.out.println(line);
}