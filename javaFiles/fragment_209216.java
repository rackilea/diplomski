@Configuration
public class Configurator {

    @Bean
    public BufferedReader bufferedReader() throws FileNotFoundException {
        return new BufferedReader(new FileReader(""));
    }

    @Bean
    public SqsMessage sqsMessage(){
        return new SqsMessage();
    }

}