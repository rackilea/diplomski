Method[] methods = product.getClass().getMethods();
for (Method m : methods){
    System.out.println(m);
    if (m.getName().equals("setHeight")){
        m.invoke(product, method_value);
        break;
    }
}