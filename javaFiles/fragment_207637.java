int start = sb.indexOf("start");
int end = sb.indexOf("end");
if (start != -1 && end != -1) {
    String fragment = sb.substring(start + "start".length(), end);
    System.out.println(fragment);
}