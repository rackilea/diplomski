GroovyClassLoader groovyCL = new GroovyClassLoader();

Class groovyShellClazz = groovyCL.loadClass(GroovyShell.class.getName());
Object groovyShellObj = groovyShellClazz.newInstance();
Method evaluateMethod = groovyShellClazz.getMethod("evaluate", String.class);
method.invoke(groovyShellObj, "println(\"test\")");