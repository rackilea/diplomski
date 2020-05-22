Calendar now = Calendar.getInstance();
Date fromDate = now.getTime();
now.add(Calendar.YEAR, 10);
Date toDate = now.getTime();

System.out.println("line 0: " + (toDate.getTime() - fromDate.getTime()));
System.out.println("line 1: " + (int)(toDate.getTime() - fromDate.getTime()));
System.out.println("line 2: " + new Long((toDate.getTime() - fromDate.getTime())).intValue());

int days = (int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24));

System.out.println("line 3: " + days);

days = ((Long) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24))).intValue();

System.out.println("line 4: " + days);