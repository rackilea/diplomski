import spock.lang.*

class SampleTest extends Specification {

    @Shared someArray

    // This is similar to just using
    // @Shared someArray = ['a','b','c']
    // Use above instead of setupSpec() if required
    // setupSpec() is invoked before any test case is invoked
    void setupSpec() {
        someArray = ['a','b','c']
    }

    def "ensure that 'Data provider has no data' is not thrown"() {
        expect:
        columnA == columnB

        where:
        [columnA, columnB] << someArray.collect { [it, it] }
    }
}