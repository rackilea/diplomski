BeanDefinitionRegistry bdr = new SimpleBeanDefinitionRegistry();
    ClassPathBeanDefinitionScanner s = new ClassPathBeanDefinitionScanner(bdr);

    TypeFilter tf = new AssignableTypeFilter(Idable.class);
    s.addIncludeFilter(tf);
    s.scan("org.willix.model");       

    entities = bdr.getBeanDefinitionNames();