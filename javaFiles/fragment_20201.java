private List getList(String nameofType) {
    List list = null;
    try {
        Class clazz = Class.forName(nameofType); //must be fully qualified, example: "java.lang.Integer"
        list = Collections.checkedList(new ArrayList(), clazz);
    } catch (ClassNotFoundException e) {
        // log exception, etc.
    }
    return list;
}