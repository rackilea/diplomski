> function printDate(x) { System.out.println(new Date(x) + " - " + new java.util.Date(x)); }

> printDate(-12219292800000)
Fri Oct 15 1582 00:00:00 GMT+0000 (GMT) - Fri Oct 15 00:00:00 GMT 1582

> printDate(-12219292800001)
Thu Oct 14 1582 23:59:59 GMT+0000 (GMT) - Thu Oct 04 23:59:59 GMT 1582