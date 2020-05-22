} else if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {
    do {
        line = br.readLine();
    }
    while(line.isEmpty() || line.trim().equals("") || line.trim().equals("\n"));
    question = line;
} else {
    question = line;
}