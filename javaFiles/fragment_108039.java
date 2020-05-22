long l = Integer.toUnsignedLong(uint);
System.out.println(l); // will print 4294967295

int x = Integer.parseUnsignedInt("4294967295");
int y = 5;
int cmp1 = Integer.compareUnsigned(x,y); // interprets x as 4294967295 (x>y) 
int cmp2 = Integer.compare(x,y); // interprets x as -1 (x<y)