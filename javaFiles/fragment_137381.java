String input = ",ab,,cde,fg,";
Scanner scan = new Scanner(input);
scan.useDelimiter("(?<=,)");
while (scan.hasNext()) {
    System.out.println(scan.next().replaceAll(",", ""));
}