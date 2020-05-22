String[] testcases = new String[] {
    "Sample foo ! Test Data", 
    "Sample bar ! Test Data", 
    "Test Data Sample foo !", 
    "Test Data Sample bar !"
};

for (String str : testcases) {
    System.out.println(str.replaceAll("(.* ?)(Sample[a-zA-Z ]+ ! ?)(.*)", "$1$3"));
}