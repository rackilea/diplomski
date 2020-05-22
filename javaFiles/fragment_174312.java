import org.joda.time.*
import org.joda.time.format.*

@Grapes([
    @Grab(group='joda-time', module='joda-time', version='1.6.2')
])

class JodaTimeTest extends GroovyTestCase {

    void testTimeZone() {
        DateTimeFormatter parser    = ISODateTimeFormat.dateTimeParser()
        DateTimeFormatter formatter = ISODateTimeFormat.dateTimeNoMillis()

        DateTime dateTimeHere     = parser.parseDateTime("2012-01-19T19:00:00-05:00")

        DateTime dateTimeInLondon = dateTimeHere.withZone(DateTimeZone.forID("Europe/London"))
        DateTime dateTimeInParis  = dateTimeHere.withZone(DateTimeZone.forID("Europe/Paris"))

        assertEquals("2012-01-20T00:00:00Z", formatter.print(dateTimeHere))
        assertEquals("2012-01-20T00:00:00Z", formatter.print(dateTimeInLondon))
        assertEquals("2012-01-20T01:00:00+01:00", formatter.print(dateTimeInParis))
    }
}