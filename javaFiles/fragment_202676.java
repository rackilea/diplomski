println 'loading application config ...'


// Place your Spring DSL code here
beans = {
    loadBeans("classpath:*security.groovy") 

}