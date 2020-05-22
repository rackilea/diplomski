Class clazz = list.get(0).getClass();
Method[] methods = clazz.getDeclaredMethods();
Method onlyStringGetter = null;
for (Method method: methods) {
    String mName = method.getName();
    if (mName.matches("get\w+") {
        if (method.getReturnType().equals(String.class) {
            if (onlyStringGetter != null) thrown new RuntimeException("More than one String getter available");
            onlyStringGetter = method;
        }
    }
}
if (onlyStringGetter == null) throw new RuntimeException("No String getter found for class: " + clazz.getName());
List<String> strings = new ArrayList<String>();
for (Object singleStringAttribObj: list) {
    // some exception handling needed for below
    String result = (String)onlyStringGetter.invoke(singleStringAttribObj);
    strings.add(result);
}
System.out.println(strings);