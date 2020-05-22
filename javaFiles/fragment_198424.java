String command = "Get-ItemProperty HKLM:\\Software\\Wow6432Node\\Microsoft\\"
               + "Windows\\CurrentVersion\\Uninstall\\* | Select-Object DisplayName, "
               + "DisplayVersion, InstallDate | ConvertTo-Json";

List<String> list;
try {
    list = runPowerShellCommand(command, false, false);
    // Display the list in console...
    for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i));
    }
}
catch (IOException ex) {
    System.err.println(ex.getMessage());
}