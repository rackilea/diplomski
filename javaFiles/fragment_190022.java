String s = "script";
if( s.matches("[^%<>^$]+") ) {
    System.out.println("valid");
} else {
    System.out.println("invalid");
}