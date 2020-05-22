class SampleSpockTest extends Specification {
   def "test sample" () {
      given:
        def internalService = Stub(InternalService)
        def subject = new ServiceUnderTestImpl(internalService)
        internalService.bar() >> {throw new IllegalArgumentException("Sample 
           exception")}
      when:
        subject.foo()
      then:
        noExceptionThrown()
     }
 }