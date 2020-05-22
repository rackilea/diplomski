int width = 10;
String columnFormat = "%-" + width + "s";
out.format(columnFormat, "This");
out.print(",");
out.format(columnFormat, "is");
out.print(",");
...