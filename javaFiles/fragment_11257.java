StringBuilder sb = new StringBuilder();
String[] split = "___This___is___the___sample___program___".split("_");
int i = 0;
for (; i < split.length - 1; i++) {
    if (split[i].length() > 0) {
        sb.append(split[i]).append("_");
    }
}
System.out.println(sb.append(split[i]));