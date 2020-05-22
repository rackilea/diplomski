String num=Integer.toString(s.nextInt());
String revNum = new StringBuffer(num).reverse().toString();
System.out.println("the reverse of the number is: " +revNum);

if(revNum.equals(num))
    System.out.println("the number is a palindrome" );
else
    System.out.println("the number entered is not a palindrome");