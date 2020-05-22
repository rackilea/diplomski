String s = "55";
Pattern p = Pattern.compile("5[12345]{1}");
if (p.matcher(s).find()) {
    System.out.println("Found");
} else {
    System.out.println("Not Found");
}