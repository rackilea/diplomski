String line = "1 2 3"; // "1 p 3"
if(line.matches("\\d+(?: \\d+)*")) {
    System.out.println("match");
} else {
    System.out.println("no match");
}