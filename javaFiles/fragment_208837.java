@Test
 public final void testFileMenuQuitMenuItem() {
     NoExitSecurityManagerInstaller noExitSecurityManagerInstaller = 
        NoExitSecurityManagerInstaller.installNoExitSecurityManager(new ExpectExitSuccess());

     gui.menuItemWithPath("File", "Quit").click();

     noExitSecurityManagerInstaller.uninstall();
 }