String str = "Class:class shapes_assignment.SquareX-Coordinate:314Y-Coordinate:50";
Matcher m = Pattern.compile(".*?(\\d+).*?(\\d+).*").matcher(str);
if (m.matches()) {
   System.out.println(m.group(1));
   System.out.println(m.group(2));
}