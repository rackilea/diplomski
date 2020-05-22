public static void main(String[] args) {
    String temp = "[[Wikipedia:Manual of Style#Links|]]";
    Pattern pattern = Pattern.compile("\\[\\[Wikipedia:([\\w ]+)#([\\w ]+)\\|\\]\\]");
    Matcher matcher = pattern.matcher(temp);

    if(matcher.find()) {            
        System.out.println("Manual of Style: " + matcher.group(1));
        System.out.println("links : " + matcher.group(2));
    }
}