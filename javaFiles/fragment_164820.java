public String PrintObj(ScriptableObject obj) {
    try {
        Person pObj = (Person)Context.jsToJava(obj, Person.class);
        System.out.println("Printing person: " + pObj);
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}