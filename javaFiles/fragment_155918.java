ArrayList member = new ArrayList();
member.add(new Member("V0001","Amy","0000-0000-0000","012-3456789","01-01-2014","01-01-2015"));
System.out.printf("\nEnter New Expired Date: ");
String expiredDate =inputS12.nextLine();
Member m=(Member)member.get(0);//First you need to get the object
m.setExpiredDate(expiredDate);
member.set(0,m);