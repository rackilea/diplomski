String osName = System.getProperty("os.name");
if (osName.startsWith("Windows")) { // or SystemUtils.IS_OS_WINDOWS if you use commons-lang
    System.setProperty("os.name", "Windows 98");  // Pretend you're on Win98
}
PrinterJob.lookupPrintServices();
System.setProperty("os.name", osName); // Restore original value