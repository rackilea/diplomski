private static List<String> getListOfAllStates() {
    List<String> list = new ArrayList<String>();

    for (Field field : StateOfSomeProcess.class.getDeclaredFields()) {
        int modifiers = field.getModifiers(); 
        if( Modifier.isStatic(modifiers) && Modifier.isFinal(modifiers) ) {
            list.add(field.getName());
        }
    } 
    return list;
}