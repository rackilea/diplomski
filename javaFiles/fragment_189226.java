The string "boo:and:foo", for example, yields the following results with these parameters:

    Regex   Limit   Result
    :   2   { "boo", "and:foo" }
    :   5   { "boo", "and", "foo" }
    :   -2  { "boo", "and", "foo" }
    o   5   { "b", "", ":and:f", "", "" }
    o   -2  { "b", "", ":and:f", "", "" }
    o   0   { "b", "", ":and:f" }