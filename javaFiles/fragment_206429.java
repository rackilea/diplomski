Scanner scanner = new Scanner(stdout);
BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(stdin));
writer.write("stop in Hello.main\n");
writer.flush();
writer.write("run Hello\n");
writer.flush();

while (scanner.hasNextLine()) {
    System.out.println(scanner.nextLine());
}