/**
  * Metamodel class for component classes
  *
  * Similar to org.springframework.beans.factory.config.BeanDefinition used by Spring
  */ 
org.jboss.seam.Component

Context context = Contexts.getApplicationContext();
for (String name: context.getNames()) {
    Object object = context.get(name);
    if(object instanceof org.jboss.seam.Component) {
        Component component = (Component) object;

        System.out.println(component.getName());
        System.out.println(component.getType());
        System.out.println(component.getScope());
        System.out.println(component.getTimeout());
        System.out.println(component.isStartup());
        System.out.println(component.isSynchronize());
    }
}