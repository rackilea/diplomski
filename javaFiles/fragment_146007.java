int total = 0;
int rowNum = 1;
while (scanner.hasNext()) {
    // comparing items in rows
    String[] parts = scanner.nextLine().split("\\s*;\\s*");
    if (!parts[0].equals(parts[1])) {
        System.out.println(rowNum + " " + parts[0] + " " + parts[1]);
        ++total;
    }
    ++rowNum;
}

System.out.println("There were " + total + " rows where the two items were not equal.");