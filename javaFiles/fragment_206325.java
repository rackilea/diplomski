public static void main(String[] args){
    Map<String, DoThings> calls = new HashMap<String, DoThings>();
    calls.add("One", new One());
    calls.add("Second", new One());

    String className = "One"; //Imagine that it come from Voice-To-Text

    DoThings instance = (DoThings) calls.get(className);
    instance.doThings();
    instance.doThings("String as argument");
}