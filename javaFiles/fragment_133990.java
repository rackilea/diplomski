in = new BufferedReader (new InputStreamReader (new ReverseLineInputStream(file)));

while(true) {
    String line = in.readLine();
    if (line == null) {
        break;
    }
    System.out.println("X:" + line);
}