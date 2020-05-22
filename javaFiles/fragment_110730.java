@Transformer(inputChannel = "input", outputChannel = "output")
@Bean
public XsltPayloadTransformer transformer() {
    return new XsltPayloadTransformer(new ClassPathResource("classpath:/test.xsl"),
            resultToDoc());
}