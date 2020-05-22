adam@brimstone:~$ ./jdk1.8.0_40/bin/javac MathTime.java;./jdk1.8.0_40/bin/java -cp . MathTime 
1.8.0_40, Math.round(float), warmup, 6846.4 ms
1.8.0_40, Math.round(float), real, 6058.6 ms
adam@brimstone:~$ ./jdk1.8.0_31/bin/javac MathTime.java;./jdk1.8.0_31/bin/java -cp . MathTime 
1.8.0_31, Math.round(float), warmup, 5717.9 ms
1.8.0_31, Math.round(float), real, 5282.7 ms
adam@brimstone:~$ ./jdk1.8.0_25/bin/javac MathTime.java;./jdk1.8.0_25/bin/java -cp . MathTime 
1.8.0_25, Math.round(float), warmup, 5702.4 ms
1.8.0_25, Math.round(float), real, 5262.2 ms