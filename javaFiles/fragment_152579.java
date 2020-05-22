String name;
do {
    name = (String) JOptionPane.showInputDialog(null, "Hello what is your name?", "The Fog", JOptionPane.INFORMATION_MESSAGE, icon1, null, "");

    if ((name == null)) {
        audioClipfog.stop();
        System.exit(0);
    }
}
while (name.equalsIgnoreCase(""));