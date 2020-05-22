String format = "%1$5s %2$-40s %3$-20s";
String someLine;
while (whatEver...) {
   ... 
   someLine = String.format(format, aNum, aName, aDate);
   jTextArea1.append(someLine + "\n");
}