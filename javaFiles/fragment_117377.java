public void forceHeavyWeight(JCompoennt fileChooser) {
    try {
        String name = "javax.swing.ClientPropertyKey";
        Class<?> keyClazz = Class.forName(name);
        Field field = keyClazz.getDeclaredField("PopupFactory_FORCE_HEAVYWEIGHT_POPUP");
        field.setAccessible(true);
        Object fieldValue = field.get(null);
        fileChooser.putClientProperty(fieldValue, true);
    } catch (Exception ex) {
        // doesn't really matter what we do here, lost anyway ;-)
        logSomehow(ex);
    }
}