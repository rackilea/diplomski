System.out.println("Supported Windows Audio Property Names");
System.out.println("======================================");
String propnames[] = (String[]) Toolkit.getDefaultToolkit().getDesktopProperty("win.propNames");
for (String propname : propnames) {
    if (propname.startsWith("win.sound.")) {
        System.out.println(propname);
    }
}