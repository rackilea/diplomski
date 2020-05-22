class Test {
    static Random r = new Random()
    Long objectId = r.nextLong()
}

//Test Case
def "consecutive IDs are not equal"() {
    given: "20 ids from 20 Test Objects"
        def ids = (1..20).collect { new Test().objectId }

    expect: "ids are unique"
        // use unique(false) not to mutate the list
        ids.unique(false) == ids
}