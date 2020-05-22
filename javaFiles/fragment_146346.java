Field[] fields = java.awt.event.KeyEvent.class.getDeclaredFields();
for (Field f : fields) {
    if (Modifier.isStatic(f.getModifiers())) {
        System.out.println(f.getName());
    } 
}