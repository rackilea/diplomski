ClassLoader cl = this.getClass().getClassLoader(); 
ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver(cl);
Resource[] resources = resolver.getResources("classpath*:/*.sql") ;
for (Resource resource: resources){
    do your things maybe print the name resource
}