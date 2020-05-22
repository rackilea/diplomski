public class ShortNumberFormatter{

    public static final long MILLION=1000000;
    public static final long THOUSAND=1000;

    public ShortNumberFormatter(){}

    private String format(String stringValue){
        if(stringValue != null){
          try {  
              long l = (long)Double.parseDouble(stringValue.trim());  
              long millions = l/MILLION;
              if(millions>=1){
                 return millions + "M"; 
              }else{
                 long thousands = l/THOUSAND;
                 if(thousands>=1){
                    return thousands + "K";
                 }else{
                    return String.valueOf(l);
                 }
              }
          } catch(NumberFormatException nfe) {  
              return "0";  
          }         
        }
        return "0";
    }

    public static void main(String []args){
        ShortNumberFormatter snFormatter = new ShortNumberFormatter();
        System.out.println(snFormatter.format("100038"));
        System.out.println(snFormatter.format("10.43e7"));
        System.out.println(snFormatter.format("123"));
    }

}