Phase: datesearching
    Input: Token Lookup
    Options: control = appelt

    Macro: DAY_ONE
    ({Token.kind == number,Token.category==CD, Token.length == "1"})

    Macro: YEAR
    ({Token.kind == number,Token.category==CD, Token.length == "4"})

    Macro: MONTH
    ({Lookup.minorType=="month"})

    Rule: ddmmyyydash
    (
        (DAY_ONE)
        ({Token.string == ","}|{Token.string == "."} |{Token.string == "-"})
        (MONTH)
        ({Token.string == ","}|{Token.string == "."} |{Token.string == "-"})
        (YEAR)
    )
    :ddmmyyyydash
    -->
        :ddmmyyyydash.DateMonthYearDash= {rule = "ddmmyyyydash"}