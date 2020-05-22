import java.beans.*

Class[] clazzes=new Class[]{<your classes here>};
for(Class c:clazzes){
   try {
    for (PropertyDescriptor pd : Introspector.getBeanInfo(c).getPropertyDescriptors()) {
        System.out.println(pd.getName()+":"+pd.getDisplayName());
          if (pd.getReadMethod() == null){
          System.out.println("No read method for : "+pd.getName()+" in : "+c);
       }
     }
} catch (IntrospectionException e) {
    e.printStackTrace();
}
}