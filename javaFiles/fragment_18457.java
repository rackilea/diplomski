public <T> T getStrategyToUse(Entity bookingCtr, Funder funder, StrategyEnum strategy) throws FunctionalException {
        String strategyToApply = null;
        strategyToApply = strategyDao.getClassToApply(bookingCtr, funder, strategy);
        Class<?> classToUse;
        try {
            classToUse = Class.forName(strategyToApply);
            T strat = (T) **autowireBeanFactory.getBean**(classToUse);
            return (T) strat;
        } catch (ClassNotFoundException e) {
            LOGGER.error("The indicated Strategy class was not found", e);
        }
        return null;
    }