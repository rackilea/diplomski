@ExtendWith(PactVerificationInvocationContextProvider.class)
@Provider("BusService") 
@PactFolder("../pacts")
public class BusStopContractTest {

    @State("There is a bus with number 613 arriving to Hammersmith bus station") 
    public void hammerSmith() {
        System.out.println("There is a bus with number 613 arriving to Hammersmith bus station" );
    }

    // A @BeforeEach method with an injected PactVerificationContext replaces
    // the old method annotated with @TestTarget
    @BeforeEach
    void setUpTarget(PactVerificationContext context) {
      context.setTarget(new HttpTarget(8111));
    }
}