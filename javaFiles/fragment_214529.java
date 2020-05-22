String path = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
Pattern p = Pattern.compile("(?<tabs>\t*)(?<segment>.+)");//dot can't match line separators
Matcher m = p.matcher(path);
int i = 1;
while(m.find()){
    System.out.println("iteration: " + i++);
    System.out.println("Preceding tabs: " + (m.group("tabs").length()));
    System.out.println("Segment: " + m.group("segment"));
    System.out.println("Rest: "+ StringEscapeUtils.escapeJava(path.substring(m.end())));
    System.out.println();
}