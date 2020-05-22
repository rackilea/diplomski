Object[] values ...
Class[] classes ...
for(Object o: values){
    add o.getClass() to classes
}

Method f = Functions.getClass().getDeclaredMethods("f", classes);
f.invoke(values);