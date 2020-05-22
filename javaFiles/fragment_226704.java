new CalculInteretsParPeriodeBuilder()
        .withEncours(10000)
        .withTauxWithMarge(1.0)
        .withDtEch(DateCalculs.getDate(2019, Month.FEBRUARY, 1))
        .withDtEchPrec(DateCalculs.getDate(2018, Month.FEBRUARY, 1))
        .withIsFirstEcheanceInterets(false);