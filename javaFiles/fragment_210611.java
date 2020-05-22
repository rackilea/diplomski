int carry = 1;
String longer = "11";
int longerInt = Integer.parseInt(String.valueOf(longer.charAt(1)));

System.out.println(carry ^ longer.charAt(1)); //48
System.out.println(carry ^ longerInt); // 0