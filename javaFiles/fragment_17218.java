// Step 0: configure your clock
String ntpServer = "ptbtime1.ptb.de";
SntpConnector clock = new SntpConnector(ntpServer);

// Step 1: Timestamp start of the program and associate it with a counter
clock.connect(); 

// Step 2: Use the counter for sequential measurements at fixed intervals
Moment m = clock.currentTime();
System.out.println(m); // possible output = 2015-06-30T23:59:60,123456789Z

// Step 3: Timestamp new counter value(s) as necessary to keep your data adequately synced
clock.connect();