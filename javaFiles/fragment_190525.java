char[][] map = new char[][10];
for(i = 0; i < 10; ++i) {
    String line = in.readLine();
    if(line == null) {
        // Realistically, you'd want better error handling than this
        System.out.println("Uh oh, the file doesn't have 10 lines!");
        return;
    }
    map[i] = line.toCharArray();
}