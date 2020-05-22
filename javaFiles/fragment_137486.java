Date d1 = ...
Date d2 = ...
long diffMs = d1.getTime() - d2.getTime();
long diffSec = diffMs / 1000;
long min = diffSec / 60;
long sec = diffSec % 60;
System.out.println("The difference is "+min+" minutes and "+sec+" seconds.");