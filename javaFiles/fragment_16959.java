String cmd = "REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\New Windows\" /F /V \"PopupMgr\" /T REG_SZ /D \"no\"";
try {
    Runtime.getRuntime().exec(cmd);
} catch (Exception e) {
    System.out.println("Error ocured!");
}