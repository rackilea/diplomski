public class Test {
    public static void main(String[] args){
        MyFormatter format = new MyFormatter("dd.MM.yyyy", "M/dd/yyyy");
        LocalDate  date = format.parse("3/30/2014"); //2014-03-30
        LocalDate  date2 = format.parse("30.03.2014"); //2014-03-30
    }
}

class MyFormatter {
    private final String[] patterns;

    public MyFormatter(String... patterns){
        this.patterns = patterns;
    }

    public LocalDate parse(String text){
        for(int i = 0; i < patterns.length; i++){
            try{
                return LocalDate.parse(text, DateTimeFormatter.ofPattern(patterns[i]));
            }catch(DateTimeParseException excep){}
        }
        throw new IllegalArgumentException("Not able to parse the date for all patterns given");
    }
}