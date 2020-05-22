public class PolarFormReal implements PolarForm {

    @Override
    public String transform(BigDecimal number) {
        //return the number as is without any transformation
        return number.toString();   
    }

}