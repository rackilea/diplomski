@Autowired
Map<String, Object> beans;

beans.get("beanOne"); // is object instance of BeanTypeOne
beans.get("beanTwo"); // is object instance of BeanTypeTwo
...
beans.get("beanN"); // is object instance of BeanTypeN