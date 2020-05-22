Object value = WinRegistry.getValue(
    RegistryRoot.HKEY_LOCAL_MACHINE, 
    "SOFTWARE\\JavaSoft\\Java Development Kit",
    "CurrentVersion", 
    RegistryView.BIT64
);
if (value != null) {
    context.setVariable("javaCurrentVersion", value.toString()); 
}