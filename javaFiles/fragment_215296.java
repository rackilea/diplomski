public static final String USER_VAR_PATH = "Environment";
public static final String SYSTEM_VAR_PATH = "SYSTEM\\CurrentControlSet\\Control\\Session Manager\\Environment";

public static void main(String[] args) {
    //Get all system environment variables
    for(String systemVariableName : getAllEnvironmetVariables(false).keySet()){
        System.out.println(systemVariableName);
    }

    //print system environment variable 'OS'
    System.out.println(getEnvironmetVariable("OS", false));

    //write to the path variable (append a string)
    String addToPath = "";
    setEnvironmetVariable("Path", getEnvironmetVariable("Path", false) + addToPath, false);
}

public static TreeMap<String, Object> getAllEnvironmetVariables(boolean user){
    HKEY root = user ? WinReg.HKEY_CURRENT_USER : WinReg.HKEY_LOCAL_MACHINE;
    String path = user ? USER_VAR_PATH : SYSTEM_VAR_PATH;
    return Advapi32Util.registryGetValues(root, path);
}

public static String getEnvironmetVariable(String key, boolean user){
    HKEY root = user ? WinReg.HKEY_CURRENT_USER : WinReg.HKEY_LOCAL_MACHINE;
    String path = user ? USER_VAR_PATH : SYSTEM_VAR_PATH;
    try{
        return Advapi32Util.registryGetExpandableStringValue(root, path, key);
    }catch(Exception e){
        return Advapi32Util.registryGetStringValue(root, path, key);
    }
}

public static void setEnvironmetVariable(String key, String value, boolean user){
    HKEY root = user ? WinReg.HKEY_CURRENT_USER : WinReg.HKEY_LOCAL_MACHINE;
    String path = user ? USER_VAR_PATH : SYSTEM_VAR_PATH;
    if(value.contains("%")){
        Advapi32Util.registrySetExpandableStringValue(root, path, key, value);
    }else{
        Advapi32Util.registrySetStringValue(root, path, key, value);
    }
}