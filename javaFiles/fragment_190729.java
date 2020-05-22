Pattern p = Pattern.compile("[0-9],[0-9],[0-9],[0-9]");

public void test(String[] args) throws Exception {
    String test = "0,1,2,3,4,5,6,7,8,9";
    Matcher m = p.matcher(test);
    if(m.find()) {
        do {
            System.out.println(m.group());
        } while(m.find(m.start()+1));
    }
}