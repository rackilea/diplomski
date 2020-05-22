class TestClass {

    String getName() {
        return "Jake"
    }
}

def parentClass = TestClass
def groovyClassLoader = new GroovyClassLoader(parentClass.classLoader)

def childClass1 = groovyClassLoader.parseClass("class ChildClass1 extends ${ parentClass.canonicalName } {}")
def oldGetName1 = childClass1.metaClass.getMetaMethod('getName', [] as Class[])
childClass1.metaClass.getName = {
    oldGetName1.invoke(delegate) + " and the Fatman"
}

def childClass2 = groovyClassLoader.parseClass("class ChildClass2 extends ${ parentClass.canonicalName } {}")
def oldGetName2 = childClass2.metaClass.getMetaMethod('getName', [] as Class[])
childClass2.metaClass.getName = {
    oldGetName2.invoke(delegate) + " the Dog"
}

assert childClass1.newInstance().name == "Jake and the Fatman"
assert childClass2.newInstance().name == "Jake the Dog"