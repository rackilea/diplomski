public class AcaProductExtractorFactory implements RateSheetProductExtractorFactory{

    @Override
    public RateSheetProductExtractor getProductExtractor(TablePlanType tablePlanType, TableRatingType ratingType){
        return new AcaProductExtractor();
    }
}

public class AcaProductExtractor implements RateSheetProductExtractor{

    @Override
    public List<ProductData> extract(SGQuotingData quotingData) {
        return null;
    }        
}



public class AgeRatedAsCompositeProductExtractorFactory implements RateSheetProductExtractorFactory{

    @Override
    public RateSheetProductExtractor getProductExtractor(TablePlanType tablePlanType, TableRatingType ratingType){
        return new AgeRatedAsCompositeProductExtractor();
    }
}

public class AgeRatedAsCompositeProductExtractor implements RateSheetProductExtractor{

    @Override
    public List<ProductData> extract(SGQuotingData quotingData) {
        return null;
    }        
}



public class MedicalProductExtractorFactory implements RateSheetProductExtractorFactory{

    @Override
    public RateSheetProductExtractor getProductExtractor(TablePlanType tablePlanType, TableRatingType ratingType){
        return new MedicalProductExtractor();
    }
}

public class MedicalProductExtractor implements RateSheetProductExtractor{
    @Override
    public List<ProductData> extract(SGQuotingData quotingData) {
        return null;
    }       
}