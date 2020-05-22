String wmClass = ...;
Toolkit toolkit = Toolkit.getDefaultToolkit();
Class<?> toolkitClass = toolkit.getClass();

if (Objects.equals("sun.awt.X11.XToolkit", toolkitClass.getName())) {

    Field awtAppClassName = toolkitClass.getDeclaredField("awtAppClassName");
    awtAppClassName.setAccessible(true);
    awtAppClassName.set(null, wmClass);
}