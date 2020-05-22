String re = "^(.).*?((?!\\1).).*?((?!\\1|\\2).).*?((?!\\1|\\2|\\3).).*?$"; 
// Good
System.out.println("1q2w3e4r5t".matches(re));
System.out.println("goody".matches(re));
System.out.println("gggoooggoofr".matches(re));
// Bad
System.out.println("good".matches(re));
System.out.println("1ab1".matches(re));