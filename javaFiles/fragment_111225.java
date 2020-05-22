final Random r=new Random();
final int t=r.nextInt(100000)+1;
// naive way:
final String s=Integer.toString(t);
System.out.println("left digit is:"+s.charAt(0));
// "math" way:
int temp=t;
while(temp>=10)
  temp/=10;
System.out.println("left digit is:"+temp);