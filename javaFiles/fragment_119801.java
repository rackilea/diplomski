import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSSX");
OffsetDateTime time = OffsetDateTime.parse("2014-02-27 16:41:51.863092+01", formatter);
System.out.println(Timestamp.from(time.toInstant()));