Function<Document, IStrategy> func = doc -> {
        String strategyToApply = "";
        IStrategy strategy = null;
        switch(doc.getPlace()) {
            case "Paris":
                strategyToApply = "strategies_classes.ProcessParis";
                break;
            case "New York":
                strategyToApply = "strategies_classes.ProcessNewYork";
                break;
            }
            case "Roma":
                ...
        try {
            **Class<?> classToUse = Class.forName(strategyToApply);
            strategy = (IStrategy) classToUse.newInstance();**
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return strategy;
};

Consumer<Document> consumerStrategy = doc -> {
    IStrategy strategy = func.apply(doc);
    strategy.bookRequest(doc);
};
documents.stream()
    .forEach(consumerStrategy);