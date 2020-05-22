@Bean
public CommandLineRunner runner(Greeter greeter) {
    return new CommandLineRunner() {

        @Override
        public void run(String... args) throws Exception {
            final Input input = new Input();
            input.setName("j");
            final String messageFromInput = greeter.getMessageFromInput(input);

            final String messageFromString = greeter.getMessageFromString("j");
        }
    };
}