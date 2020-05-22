jshell> /open HasStaticInitBlock.java

jshell> /list

1 : import java.time.Duration;
2 : import java.time.Instant;
3 : class HasStaticInitBlock {
        static Instant t0 = Instant.now();
        static {
            System.out.println("Class initialized at " + t0);
        }
        static Duration timeSinceInit() {
            return Duration.between(t0, Instant.now());
        }
    }

jshell> HasStaticInitBlock.timeSinceInit()
Class initialized at 2017-06-07T06:49:06.746185Z
$4 ==> PT0.040414S

jshell> HasStaticInitBlock.timeSinceInit()
$5 ==> PT2.343019S