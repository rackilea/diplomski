import java.text.DateFormat
import java.util.TimeZone

println Locale.getDefault()
Date d = new Date(1317322560000)
println d
Locale.setDefault(new Locale("it", "IT"))
println Locale.getDefault()

DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);
println df.getTimeZone().getOffset(1317322560000) + " => +2h offset in 'summer time' (DST on)"

df.setTimeZone(TimeZone.getTimeZone("GMT+00:00"))
println df.format(d)
df.setTimeZone(TimeZone.getTimeZone("GMT+01:00"))
println df.format(d)
df.setTimeZone(TimeZone.getTimeZone("GMT+02:00"))
println df.format(d)
df.setTimeZone(TimeZone.getTimeZone("Europe/Rome"))
println df.format(d)
println "---"

Date winterDate = new Date(1321382560000)
println winterDate
println df.getTimeZone().getOffset(1321382560000) + " => +1h offset in 'winter time' (DST off)"