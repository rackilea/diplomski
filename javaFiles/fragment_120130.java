class SamplePlugin implements Plugin {
   void apply(Object p) {
      p.extensions.create("e", MyPluginExtension)
   }
}

class MyPluginExtension { 

    Property2 property2 = new Property2()
    String property1

    def property2(Closure c) {
      c.resolveStrategy = Closure.DELEGATE_FIRST
      c.delegate = property2
      c()
    }
}

class Property2 {
    String a1
    String a2

    def a1(a1) {
      this.a1 = a1
    }

    def a2(a2) {
      this.a2 = a2
    }
}

apply plugin: SamplePlugin

e {
   property1 'lol'
   property2 {
      a1 'lol2'
      a2 'lol3'
   }
}

println e.property1
println e.property2.a1