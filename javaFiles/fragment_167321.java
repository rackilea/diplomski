public C(..., int yearX, ...) throws InitException {
        year = yearX;
        if (year == 2008) {
            ...
        } else
            throw new InitException();
    }