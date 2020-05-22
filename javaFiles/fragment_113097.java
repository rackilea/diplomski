Thread.sleep(1000);
System.out.println("going to wait mode");
cnt1.suspendme();
Thread.sleep(1000);
System.out.println("resuming");
cnt1.resumeme();
Thread.sleep(1000);