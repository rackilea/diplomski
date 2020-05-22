public static Class<MyInterface> getClassById(Long id) throws ClassNotFoundException {
    if(d.id == 1L) {
        return First.class;
    } else if(d.id ==2L) {
        return Second.class;
    } else if(d.id ==3L) {
        return Third.class;
    } else {
        throw new ClassNotFoundException();
    }
}