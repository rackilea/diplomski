@TestConfiguration
public class AllMockInjector {
    @Bean
    public IServer createServer(){
        return new MockServer();
    }

    @Bean
    public IClient createClient(){
        return new MockClient();
    }
}

@TestConfiguration
public class MockServerInjector{
    @Bean
    public IServer createServer(){
        return new MockServer();
    }

    @Bean
    public IClient createClient(){
        return new RealClient();
    }
}

@TestConfiguration
public class MockClientInjector{
    @Bean
    public IServer createServer(){
        return new RealServer();
    }

    @Bean
    public IClient createClient(){
        return new MockClient();
    }
}