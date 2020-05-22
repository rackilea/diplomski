String s = "aged01";
if(s.matches(".*[g-zG-Z].*")) {
    System.out.println("Error:String contains a letter from g-zG-Z");
}
else {
    System.out.println(s);
}