long m0 = Runtime.getRuntime().freeMemory();
Object obj = new Object();
long m1 = Runtime.getRuntime().freeMemory();
if (m1 == m0)
    throw new AssertionError("Please disable the TLAB with -XX:-UseTLAB");
System.out.println(m0 - m1);