public static <T> Container<T> sec(String json, Class<T> clazz) {
        Type type1 = new TypeToken<Container<T>>() { }.getType();
        Type type = TypeToken.getParameterized(Container.class,clazz).getType();
        System.out.println(type1);   //==>pl.jac.container.Container<T>
        System.out.println(type);    //==>pl.jac.container.Container<pl.jac.container.Record>
        return new Gson().fromJson(json, type);
    }