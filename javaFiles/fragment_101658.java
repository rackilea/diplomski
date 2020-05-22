@SpringBootApplication
public class So54865968Application {

    public static void main(String[] args) {
        SpringApplication.run(So54865968Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(Foo foo) {
        return args -> {
            foo.runInTx();
            System.out.println("Committed 1");
            foo.runInLocalTx();
            System.out.println("Committed 2");
        };
    }

    @Bean
    public Foo foo(KafkaTemplate<String, Object> template) {
        return new Foo(template);
    }

    @Bean
    public Bar bar() {
        return new Bar();
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic("so54865968-1", 1, (short) 1);
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic("so54865968-2", 1, (short) 1);
    }

    public static class Foo {

        private final KafkaTemplate<String, Object> template;

        public Foo(KafkaTemplate<String, Object> template) {
            this.template = template;
        }

        @Transactional(transactionManager = "kafkaTransactionManager")
        public void runInTx() throws InterruptedException {
            this.template.send("so54865968-1", 42);
            this.template.send("so54865968-2", "texttest");
            System.out.println("Sent 2; waiting a few seconds to commit");
            Thread.sleep(5_000);
        }

        public void runInLocalTx() throws InterruptedException {
            this.template.executeInTransaction(t -> {
                t.send("so54865968-1", 43);
                t.send("so54865968-2", "texttest2");
                System.out.println("Sent 2; waiting a few seconds to commit");
                try {
                    Thread.sleep(5_000);
                }
                catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                return true;
            });
        }

    }

    public static class Bar {

        @KafkaListener(id = "foo", topics = { "so54865968-1", "so54865968-2" })
        public void haandler(byte[] bytes) {
            if (bytes.length == 4) {
                ByteBuffer bb = ByteBuffer.wrap(bytes);
                System.out.println("Received int " + bb.getInt());
            }
            else {
                System.out.println("Received string " + new String(bytes));
            }
        }

    }

}