Welcome to Scala version 2.11.7 (OpenJDK 64-Bit Server VM, Java 1.8.0_65).
Type in expressions to have them evaluated.
Type :help for more information.

scala> import org.joda.time.{DateTimeZone, DateTime}
import org.joda.time.{DateTimeZone, DateTime}

scala> new DateTime("1429200236824".toLong, DateTimeZone.forID("Etc/UTC")).dayOfWeek.getAsText
warning: Class org.joda.convert.FromString not found - continuing with a stub.
warning: Class org.joda.convert.ToString not found - continuing with a stub.
warning: Class org.joda.convert.ToString not found - continuing with a stub.
warning: Class org.joda.convert.FromString not found - continuing with a stub.
warning: Class org.joda.convert.ToString not found - continuing with a stub.
res0: String = Thursday

scala>