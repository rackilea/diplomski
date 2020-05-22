String numbers = "012345";

System.out.println(numbers.replaceAll(".", "<$0>"));
// <0><1><2><3><4><5>

System.out.println(numbers.replaceAll("^.", "<$0>"));
// <0>12345

System.out.println(numbers.replaceAll(".$", "<$0>"));
// 01234<5>

numbers = "012\n345\n678";
System.out.println(numbers.replaceAll("^.", "<$0>"));       
// <0>12
// 345
// 678

System.out.println(numbers.replaceAll("(?m)^.", "<$0>"));       
// <0>12
// <3>45
// <6>78

System.out.println(numbers.replaceAll("(?m).\\Z", "<$0>"));     
// 012
// 345
// 67<8>