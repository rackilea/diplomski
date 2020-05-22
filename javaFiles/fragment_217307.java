String[] parts = s.split("bread");
if (parts.length == 3) {
    System.out.println(parts[1]);
} else {
    System.out.println("Not enough or too much bread");
}