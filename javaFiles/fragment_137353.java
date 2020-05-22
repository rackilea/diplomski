public class BonusEnumGenerator implements Generator {

    public Date bonusAppliedDate;
    public String description;    
    //GET, SET

    public Bonus generate() {
        //implementation
    }

    public void applyParams(GeneratorParams params) throws InvalidParamException {
        if(!(params instanceof BonusEnumGeneratorParams))
            throw new InvalidParamException();
        else
            // assign values
    }    
}