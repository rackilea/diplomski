public class DateGenerator implements Generator {    
    public String queryString;
    public Integer order;    
    //GET, SET

    public Date generate(){
        //implementation
    }

    @Override
    public void applyParams(GeneratorParams params) throws InvalidParamException {
        if(!(params instanceof DateGeneratorParams))
            throw new InvalidParamException();
        else
        // assign values
    }    
}