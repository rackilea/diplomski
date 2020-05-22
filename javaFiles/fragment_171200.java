@Configuration
@Profile("inputHandler")
public class InputHandlerConfiguration {

    // ...

}

@Configuration
// no profile - applicable to all profiles
public class CommonConfiguration {

    // ...

}