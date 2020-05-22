String rex = "^\\d+\\.\\s\\p{Lu}+.*";

System.out.println("1. PTYU fmmflksfkslfsm".matches(rex));
// true

System.out.println(". PTYU fmmflksfkslfsm".matches(rex));
// false, missing leading digit

System.out.println("1.PTYU fmmflksfkslfsm".matches(rex));
// false, missing space after .

System.out.println("1. xPTYU fmmflksfkslfsm".matches(rex));
// false, lower case letter before the upper case letters