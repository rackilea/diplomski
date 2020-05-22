@Stateless 
public class NewsLetterGeneratorBean implements NewsLetterGenerator {
    @Schedule(second="0", minute="0", hour="0", dayOfMonth="1", month="*", year="*") 
    public void generateMonthlyNewsLetter() { 
        ... Code to generate the monthly news letter goes here...
    }
}