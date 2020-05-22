public class DateGeneratorParams extends GeneratorParams {

    public String queryString;
    public Integer order;   
    //    GET, SET
}

public class BonusEnumGeneratorParams implements GeneratorParams {

    public Date bonusAppliedDate;
    public String description;    
    //    GET, SET 
}