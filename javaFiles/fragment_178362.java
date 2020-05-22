Scanner scanner = new Scanner(new File("file.txt"));
int i = 0;
while (scanner.hasNextLine()) {
    String first = scanner.next();
    String second = scanner.next();
    String last = scanner.next();
    //System.out.println(first+": "+second+": "+last);
    i++;
}