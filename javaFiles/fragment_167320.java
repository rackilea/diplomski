public C(..., int yearX, ...) throws InitException {
        if (year == 2000) {
            ...
            year = yearX;
            ...
        } else
            throw new InitAnneeEC();
    }