while (inputStream.hasNextLine()) {
    line = inputStream.nextLine();
    words = line.split(" ");
}


    for (int i = 0; i < words.length; i++) {
        System.out.println(words[i]);
    }
}