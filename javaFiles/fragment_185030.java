Context contxt = getApplicationContext();
CustomClass custmClass = new CustomClass(contxt);
ArrayList<Object> parameters = new ArrayList<Object>();
parameters.add(contxt);
...
custmClass.execute(parameters);