public static void create() {
    MyObject obj = new MyObject();
    obj.save();
    Long id = obj.id;
    renderJSON(id);
}