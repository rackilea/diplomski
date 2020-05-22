enum CalendarBasisStrategyType { FISCAL_YEAR, CALENDAR }

    static EnumMap<CalendarBasisStrategyType, CalendarBasisFactory> lookupFactory = new EnumMap();
    {
        ...
    }


    CalendarBasisStrategy toStrategy(CalendarBasisStrategyType type) {
        return lookupFactory.get(type).newInstance();
    }