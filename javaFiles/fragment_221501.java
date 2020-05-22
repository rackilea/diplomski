String regex = "x*(yx*)?|y*(xy*)?";

System.out.println("xxx".matches(regex));
System.out.println("xxxy".matches(regex));
System.out.println("xxyx".matches(regex));
System.out.println("xxxyy".matches(regex));