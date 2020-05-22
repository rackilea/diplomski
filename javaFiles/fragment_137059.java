String givenString = "xyz a z";
String[] split = givenString.split(" ");
StringBuffer secondPart = new StringBuffer();
for (int i = 1; i < split.length; i++) {
    secondPart.append(split[i]);
}
StringBuffer finalPart = new StringBuffer();
finalPart.append(split[0]);
finalPart.append(" ");
finalPart.append(secondPart.toString());
System.out.println(finalPart.toString());