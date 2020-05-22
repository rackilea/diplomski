@Component
@Profile("test")
public class ProcessorFake implements Processor {

    // Implement without actually reading from a file
}

@Component
@Profile("qa", "prod", "dev")
public class ProcessorClass implements Processor {
    // Real class used with other profiles
}