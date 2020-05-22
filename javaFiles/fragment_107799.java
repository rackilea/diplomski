public void identify() {
    // the rest of your code
    String id = rs.getString("Cliente_Id");
    ui.setClienteid(id);
    // call the Javascript function
    JSObject.getWindow(ui).eval(String.format("foo(%s)", id));
}