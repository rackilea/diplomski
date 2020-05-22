File exe = new File(FileName.installation + File.separator + "install_update.bat");

if (Desktop.isDesktopSupported()) {
    Desktop.getDesktop().open(exe);
} else {
    Runtime.getRuntime().exec("cmd /c pushd " + FileName.installation + " && start install_update.bat && popd");
}