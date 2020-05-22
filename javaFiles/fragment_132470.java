String s = "from:09/26/2011,type:all,to:09/26/2011,field1:emp_id,option1:=,text:1234";

int i = s.indexOf(',', 1 + s.indexOf(',', 1 + s.indexOf(',')));

String firstPart = s.substring(0, i);
String secondPart = s.substring(i+1);

System.out.println(firstPart);
System.out.println(secondPart);