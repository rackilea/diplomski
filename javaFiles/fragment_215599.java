enum CalendarBasisStrategyType { FISCAL_YEAR, CALENDAR }

    static EnumMap<CalendarBasisStrategyType, CalendarBasisStrategy> lookupStrategy = new EnumMap();
    {
        lookupStrategy.put(FISCAL_YEAR, new FiscalYearStrategyObject());
        lookupStrategy.put(CALENDAR, new CalenderBasisStrategyObject());
    }


    CalendarBasisStrategy toStrategy(CalendarBasisStrategyType type) {
        return lookupStrategy.get(type);
    }