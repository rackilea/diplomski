// say the clock value happens to be Long.MAX_VALUE - 10
long ts1 = 9223372036854775797L;

// 100 ns later it has overflowed (it is now negative)
long ts2 = ts1 + 100;

System.out.println("ts2 - ts1 > 0 : " + (ts2 - ts1 > 0));
System.out.println("ts2 > ts1 : " + (ts2 > ts1));