public class CompositeRateSheetProductExtractorFactory implements RateSheetProductExtractorFactory{
    private Map<String, RateSheetProductExtractorFactory> factoryMap = null;

    public void setFactoryMap(Map<String, RateSheetProductExtractorFactory> factoryMap){
        this.factoryMap = factoryMap;
    }

    @Override
    public RateSheetProductExtractor getProductExtractor(TablePlanType tablePlanType, TableRatingType ratingType){
        RateSheetProductExtractorFactory factory = factoryMap.get( tablePlanType + "-" + ratingType );

        if (factory == null) throw new IllegalArgumentException( tablePlanType + "-" + ratingType + " is unsupported yet.");

        return factory.getProductExtractor(tablePlanType, ratingType);
    }        
}