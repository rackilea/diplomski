JFileChooser chooser = new JFileChooser();
FileNameExtensionFilter filter = new FileNameExtensionFilter("APK Files", "apk");
chooser.setFileFilter(filter);
int returnVal = chooser.showOpenDialog(getParent());
if (returnVal == JFileChooser.APPROVE_OPTION) {
    File file = chooser.getSelectedFile();
    String filename = chooser.getSelectedFile().getName();
    try {
        String[] commands = new String[3];
        commands[0] = "adb";
        commands[1] = "install";
        commands[2] = file.getAbsolutePath();
        Process p1 = Runtime.getRuntime().exec(commands, null);
        p1.waitFor();
                            } catch (Exception e1) {
        System.err.println(e1);
    }
}