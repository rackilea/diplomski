else if (!testTokens.nextToken().matches("quality|numInStock|basePrice"))
    {
        throw new InvalidLValueException();
    }
    else if (!testTokens.nextToken().matches(">|<|>=|<=|=="))
    {
        throw new InvalidOperatorException();
    }