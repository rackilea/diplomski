@Bean
@Transformer(inputChannel = "enrichChannel", outputChannel = "processChannel")
public HeaderEnricher headerEnricher() {
    HeaderEnricher headerEnricher = new HeaderEnricher (...);
    ....
    return headerEnricher;
}