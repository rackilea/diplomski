String input = "abxxefyyg";
input = input.replaceAll("[^xy]+", "");
String[] parts = input.split("(?<=(.))(?!\\1)");
System.out.println(Arrays.toString(parts));
if (parts[0].length() == parts[1].length()) {
    System.out.println("MATCH");
}
else {
    System.out.println("NO MATCH");
}