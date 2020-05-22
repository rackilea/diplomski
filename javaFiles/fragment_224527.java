interface ServiceUnderTest {
   void foo()
}
interface InternalService {
   int bar() throws IllegalArgumentException
}

class ServiceUnderTestImpl implements ServiceUnderTest {
    InternalService internalService
    ServiceUnderTestImpl(InternalService internalService) {
       this.internalService = internalService
    }

    void foo() {
        try {
          internalService.bar()
        } catch(IllegalArgumentException ex) {
          println "Got you"
        }
    }
 }