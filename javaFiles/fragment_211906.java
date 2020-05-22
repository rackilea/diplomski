@Grapes(
    @Grab(group='joda-time', module='joda-time', version='2.5')
)

import org.joda.time.*
import org.joda.time.format.*

Map<String, List<String>> equivalentZones = new HashMap<String, List<String>>()

DateTimeZone.getAvailableIDs().each { id ->
    DateTimeZone dtz = DateTimeZone.forID(id)
    zonesForID = equivalentZones.get(dtz.ID, [])
    if (id != dtz.ID) {
        zonesForID << id        
    }
    equivalentZones.put(dtz.ID, zonesForID)
}

equivalentZones.each { k,v ->
    println "$k -> $v"
}