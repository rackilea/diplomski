PrintWriter pw = new PrintWriter(...file/stream...);
Scanner sc = new Scanner(...your file/stream/string...);
while (sc.hasNextLine()) {
    String line = sc.nextLine();
    String[] parts = line.split(",");
    int first = Integer.parseInt(parts[0]);
    int second = Integer.parseInt(parts[1]);
    second *= 5;
    pw.println(first + "," + second);
}
sc.close();
pw.close();