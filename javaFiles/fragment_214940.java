public static void main(String[] args) {
    String[] testList = {"a1@b.com", 
            "a2@b.com abcd efg", 
            "x y z a3@b.com", 
            "p q a4@b.com x z", 
            "asd[a5@b.coom]gh"};

    Pattern EMAIL_PATTERN = Pattern.compile("[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})");


    for(String test : testList){
        Matcher m = EMAIL_PATTERN.matcher(test);
        while (m.find()) {
             System.out.println(m.group(0));
        }
    }
}