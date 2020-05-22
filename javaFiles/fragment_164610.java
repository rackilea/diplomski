class Dsl {
  static void main(args) {
      new Integrator().runIt()
  }
}

class DslDelegate {
    def service
    def callService(service) {
        this.service = service
        this
    }

    def getProperty(String prop) {
      if (prop == "getMethod") { service.getMethod() }
      else { throw new RuntimeException("Unrecognized property '$prop'") }
    }
}

class ServiceClass {
  def getMethod() { "serviceClass getMethod" }
}

class Integrator{
    def dslDelegate = new DslDelegate()
    def binding = new Binding([
        ServiceClass: new ServiceClass(), 
        callService:dslDelegate.&callService ])
    def shell = new GroovyShell(binding)

    def runIt() {
        assert shell.evaluate(new File("userCommand")) == 
            "serviceClass getMethod"
    }
}