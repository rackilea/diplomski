string="I love #computers so much.";
String[] parts = string.split("#");
String part1 = parts[0]; // I love 
String part2 = parts[1]; // computers so much.

String[] parts2 = part2.split(" ");
String output = parts2[0];