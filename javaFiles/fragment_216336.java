public void foo(List<Object> list) {
    if (!list.isEmpty()) {
        Object object = list.get(0);
        //using instanceof
        if (object instanceof Cat) {
        }
        if (object instanceof Orange) {
        }
        //using getClass().equals
        if (object.getClass().equals(Cat.class)) {
        }
        if (object.getClass().equals(Orange.class)) {
        }
    }
}