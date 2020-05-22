String delimiter = "\\d\\.\\s";
String cl =  ".WKS 1. Lotus Worksheet (filename extension). 2. Microsoft Works document (filename extension).";
String split[] = cl.split(" ", 2);

String name = split[0];

String description = split[1];

String splitted[] = description.split(delimiter);

System.out.println("name=" + name);
System.out.println("description" + description);

for (String s : splitted) {
    System.out.println(s);
}