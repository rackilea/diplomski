@Grab('org.spockframework:spock-core:0.7-groovy-2.0')
@Grab('cglib:cglib-nodep:3.1')

import spock.lang.*

class Test extends Specification {
    def "test execute(inputTuple) method emits an outputTuple containing a member ObjectType retrieved using the entity_id in inputTuple"() {
        given:    
        List<String> objectTypeIDsEmittedByPreviousBolt = new ArrayList<String>();
        objectTypeIDsEmittedByPreviousBolt.add("member");
        objectTypeIDsEmittedByPreviousBolt.add("1196");

        Tuple inputTuple = new Tuple(objectTypeIDsEmittedByPreviousBolt);

        Bolt bolt = new Bolt()
        Collector collector = GroovyMock(Collector)
        bolt.collector = collector

        when:
        bolt.execute(inputTuple);

        then:
        1 * collector.ack(inputTuple);
    }
}

class Bolt {
    Collector collector = new Collector()
    def execute(o) {
        collector.ack(o)
    }
}

class Collector {
    def ack(o) {
        println o
    }
}