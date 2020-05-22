Field[] fields = aClass.getFields();
for (Field field : fields) {
     // get value
     Object value = field.get(objectInstance);
     // check the values are different, then update 
     field.set(objetInstance, value);    
}