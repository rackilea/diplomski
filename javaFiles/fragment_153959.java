Generex generex = new Generex(regex);
Iterator iterator = generex.iterator();
System.out.println("Possible strings against the given Regular Expression;\n");
StringBuilder sb = new StringBuilder();
int limitOfChars = 100; //for example
while (iterator.hasNext()) {
    String next = iterator.next();
    if (sb.length() + next.length() > limitOfChars) break;
    sb.append(next + " ");
}
System.out.println(sb.toString() + " ... ");