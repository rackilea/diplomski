Pattern pattern = Pattern.compile("\\d+f\\d+(?:-\\d+)?");
for (String s : new String[] {
    "2f6", "2f9", "6f10", "5f9-2", "3f4-9"
}) {
    System.out.println("String: \""+s+"\" match: "+pattern.matcher(s).matches());
}