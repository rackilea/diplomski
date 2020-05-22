String test="x=y+z/n-10+my5th_integer+201";
Pattern mypattern = Pattern.compile("[a-zA-Z_$][a-zA-Z_$0-9]*");
Matcher mymatcher = mypattern.matcher(test);    
while (mymatcher.find()) {
    String find = mymatcher.group(0) ;
    System.out.println("variable:" + find);
}