@SpringBootApplication
public class SftpJavaApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SftpJavaApplication.class)
            .web(false)
            .run(args);
    }

    @Bean
    public IntegrationFlow sftpInboundFlow() {
        return IntegrationFlows
            .from(Sftp.inboundAdapter(this.sftpSessionFactory)
                    .preserveTimestamp(true)
                    .remoteDirectory("foo")
                    .regexFilter(".*\\.txt$")
                    .localFilenameExpression("#this.toUpperCase() + '.a'")
                    .localDirectory(new File("sftp-inbound")),
                 e -> e.id("sftpInboundAdapter")
                    .autoStartup(true)
                    .poller(Pollers.fixedDelay(5000)))
            .handle(m -> System.out.println(m.getPayload()))
            .get();
    }
}