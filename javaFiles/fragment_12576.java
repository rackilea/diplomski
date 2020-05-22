Scanner in = new Scanner (new InputStreamReader (new ReverseLineInputStream(file)));

for (int b=0; b<5; b++) {
    String line = in.nextLine();
    if (line == null) {
        break;
    }
    System.out.println(line);
}