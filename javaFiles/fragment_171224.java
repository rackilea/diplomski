Bson one = Filters.and(Filters.eq("aid", "TS123"),
        Filters.eq("year", "2018"),
        Filters.eq("position", "testCases"));
Bson two = Filters.and(Filters.eq("aid", "TS123"),
        Filters.eq("year", "2018"),
        Filters.eq("position", "testCases"));

// one and two are not equal because Bson does not implement equals so 
// we'll just fall back to the standard instance check in Object
assertNotEquals(one, two);