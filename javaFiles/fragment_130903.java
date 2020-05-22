@ComponentScan(
    basePackages = { "org.fandom.configclass" },
    excludeFilters = { 
            @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class) 
    }
)