StringTokenizer testTokens = new StringTokenizer(input, " ,");

    if (!testTokens.nextToken().equalsIgnoreCase("report"))
    {
        throw new IllegalStartOfQueryException();
    }
    else if (!testTokens.nextToken().equalsIgnoreCase("all"))
    {
        throw new InvalidSelectorException();
    }
    else if (!testTokens.nextToken().equalsIgnoreCase("where"))
    {
        throw new InvalidQualifierException();
    }

    // TODO here i use local variables, since you need to use these outside this method,
    // maybe use class fields or whatever else
    String subject = testTokens.nextToken();
    String opttok = testTokens.nextToken();

    if (!subject.matches("quality|numInStock|basePrice"))
    {
        throw new InvalidLValueException();
    }
    else if (!opttok.matches(">|<|>=|<=|=="))
    {
        throw new InvalidOperatorException();
    }

    // done, now you have opttok and subject