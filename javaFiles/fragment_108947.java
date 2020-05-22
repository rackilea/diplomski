import groovy.lang.*;
...

public static void main(String[]s)throws Exception{
    GroovyClassLoader cl=new GroovyClassLoader();
    //path to base folder where groovy classes located
    cl.addClasspath(path_to_groovy_root); 
    //the groovy file with SearchQueryBase.groovy
    //must be located in "com/test/dev/search" subfolder under path_to_groovy_root
    Class c = cl.loadClass("com.test.dev.search.SearchQueryBase");
    SearchQuery o = (SearchQuery) c.newInstance();
    System.out.println( o.getMatterQuery(test) );
}