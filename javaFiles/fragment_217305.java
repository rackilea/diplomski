String cheese;
String bread = "bread";
int firstIndex = s.indexOf(bread);
int lastIndex = s.lastIndexOf(bread);
if (firstIndex == -1) {
    cheese = "no bread";
} else if (lastIndex == firstIndex) {
    cheese = "only one bread";
}
cheese = s.substring(firstIndex + bread.length(), lastIndex);

System.out.print(cheese);